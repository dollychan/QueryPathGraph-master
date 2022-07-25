package com.qpg.model.nosql.Doc;

import com.qpg.model.nosql.NoSQLDataUnit;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGNode;
import com.qpg.model.uml.UMLAttribute;

import java.util.*;

public class DocModel extends NoSQLDataUnit {
  private String coll_name;
  private List<DocField> fields;
  private List<DocField> keys;
  private Map<String, List<DocField>> indexes;

  public DocModel(){
    coll_name = "";
    fields = new ArrayList<>();
    indexes = new HashMap<>();
  }

  private void addField(DocField f){fields.add(f);}
  private void addIndex(String al, DocField f){
    if(indexes.get(al) == null) indexes.put(al, new ArrayList<>());
    indexes.get(al).add(f);
  }

  @Override
  public void map(QPGNode root, List<String> agg_labels) {
    /*int n = 0;
    for(String agg_label: agg_labels){
      if(n++>0)
        coll_name+= "_";
      coll_name+=agg_label;
    }*/
    coll_name = root.getNodeName();
    String prefix = "";
    mapNode(null, root, agg_labels, this, prefix);

    mergeIndexes();
    setKeys();
    if(keys.isEmpty()){
      for(UMLAttribute a: root.getUmlClass().getPks()){
        keys.add(new DocField(root.getNodeName(),a,prefix));
      }
    }
  }

  private void mergeIndexes(){
    List<String> remove = new ArrayList<>();
    for(int i = 0; i< indexes.keySet().size(); i++){
      String al1 = (String) (indexes.keySet().toArray()[i]);
      if(remove.contains(al1))
        continue;
      for(int j = i+1; j < indexes.keySet().size(); j++){
        String al2 = (String) (indexes.keySet().toArray()[j]);
        if(remove.contains(al2))
          continue;
        if(indexes.get(al1).size() != indexes.get(al2).size()) continue;

        boolean flag2 = true;
        for(DocField f1: indexes.get(al1))
        {
          boolean flag = false;
          for(DocField f2: indexes.get(al2)) {
            if (f1 == f2) {flag = true; break;}
          }
          if(!flag) {flag2 = false; break;}
        }
        if(flag2) remove.add(al2);
      }
    }
    for(String r: remove)
      indexes.remove(r);
  }

  private void setKeys(){
    if(indexes.keySet().size()==1) {
      keys = indexes.get(indexes.keySet().toArray()[0]);
      indexes = null;
    }else{
      keys = new ArrayList<>();
      Map<DocField, Integer> shared = new HashMap<>();
      for(String al: indexes.keySet()){
        for(DocField f : indexes.get(al)){
          if(shared.get(f) == null) shared.put(f,0);
          shared.put(f, (shared.get(f)+1));
        }
      }
      int num = indexes.keySet().size();
      for(DocField f: shared.keySet()){
        if(shared.get(f) == num)
          keys.add(f);
      }
    }
  }

  private void mapNode(QPGEdge in_edge, QPGNode node, List<String > agg_labels, DocModel doc, String prefix){
    Set<UMLAttribute> keys = new HashSet<>();
    Set<UMLAttribute> attrs = new HashSet<>();

    List<String> node_agg_labels = new ArrayList<>();// different from agg_labels, except the root.
    for(String al: agg_labels){
      if(node.involvedInAgg(al))
        node_agg_labels.add(al);
      else continue;
      keys.addAll(node.getEAattrs(al));
      keys.addAll(node.getIAattrs(al));
      keys.addAll(node.getOAattrs(al));
      attrs.addAll(node.getPAattrs(al));
    }

    for(UMLAttribute attr: keys){
      DocField f = new DocField(node.getNodeName(), attr, prefix);
      doc.addField(f);
      for(String al:node_agg_labels){
        if(node.getEAattrs(al).contains(attr)) addIndex(al, f);
        if(node.getIAattrs(al).contains(attr)) addIndex(al,f);
        if(node.getOAattrs(al).contains(attr)) addIndex(al,f);
      }
    }

    for(UMLAttribute attr: attrs){
      if(keys.contains(attr))
        continue;
      doc.addField(new DocField(node.getNodeName(), attr, prefix));
    }

    if(in_edge != null) {
      Map<UMLAttribute,DocField> edge_attrs = new HashMap<>();
      for(String al:node_agg_labels) {
        Set<UMLAttribute> edge_keys = new HashSet<>();
        edge_keys.addAll(in_edge.getEAattrs(al));
        edge_keys.addAll(in_edge.getIAattrs(al));
        edge_keys.addAll(in_edge.getOAattrs(al));
        for(UMLAttribute a: edge_keys){
          if(edge_attrs.get(a) == null){
            DocField f = new DocField(in_edge.getEdgeName(), a, prefix);
            doc.addField(f);
            edge_attrs.put(a, f);
          }
          addIndex(al, edge_attrs.get(a));
        }
        for(UMLAttribute a: in_edge.getPAattrs(al)){
          if(edge_keys.contains(a)) continue;
          if(edge_attrs.get(a) == null){
            DocField f = new DocField(in_edge.getEdgeName(), a, prefix);
            doc.addField(f);
            edge_attrs.put(a, f);
          }
        }
      }
    }

    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(agg_labels)){
        if(edge.getCard(edge.getEndNode()) > 1){
          String new_prefix = prefix;
          DocModel doc_child = new DocModel();
          DocField f = new DocField(edge.getEndNode().getNodeName(), doc_child, true, new_prefix);
          doc.addField(f);
          if(!new_prefix.equalsIgnoreCase("")) new_prefix+=".";
          new_prefix = edge.getEndNode().getUmlClass().getName();
          mapNode(edge, edge.getEndNode(), node_agg_labels, doc_child, new_prefix);
        }else{
          mapNode(edge, edge.getEndNode(), node_agg_labels, doc, prefix);
        }
      }
    }
  }

  @Override
  public String genNoSQLScript() {
    return print();
  }

  @Override
  public String print() {
    String str = "Collection:"+coll_name+ printDoc();
    str+='\n';

    str += "keys:{";
    for(DocField f: keys){
      str += f.getPrefixName() +",";
    }
    str+="}\n";

    if(indexes != null){
    for(String al: indexes.keySet()){
      str += "index:{";
      for(DocField f: indexes.get(al)){
        str += f.getPrefixName() +",";
      }
      str+="}\n";
    }
    }
    return str;
  }

  @Override
  public String getName() {
    return coll_name;
  }

  private String printDoc() {
    String str = "{";
    for(DocField f: fields){
      str += f.print();
    }
    str += "}";
    return str;
  }

  private class DocField {
    private String f_name;
    private boolean isPrimitive;
    private String pri_type;
    private DocModel doc_type;
    private boolean isList;
    private String prefix; //for embedded documents, e.g. orderList.order_id, orderList.itemList.item_id

    private String getPrefixName(){
      if(!prefix.equalsIgnoreCase(""))
        return prefix+"."+f_name;
      else
        return f_name;
    }

    private  DocField(String class_name, UMLAttribute attr, String prefix){
      f_name = class_name+"_"+attr.getName();
      isPrimitive = true;
      pri_type = attr.getType();
      isList = attr.isMultiValued();
      this.prefix = prefix;
    }

    private DocField(String f_name, DocModel doc_type, boolean isList, String prefix){
      this.f_name = f_name;
      isPrimitive = false;
      this.doc_type = doc_type;
      this.isList = isList;
      this.prefix = prefix;
    }

    private String print(){
      String str = f_name + ":";
      if(isPrimitive){
        if(isList)  str+= "["+pri_type+"]";
        else  str+= pri_type;
      }else{
        str += doc_type.printDoc();
      }
      return str +";\n";
    }

  }


}
