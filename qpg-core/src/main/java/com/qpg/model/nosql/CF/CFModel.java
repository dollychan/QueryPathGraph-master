package com.qpg.model.nosql.CF;

import com.qpg.model.nosql.NoSQLDataUnit;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGNode;
import com.qpg.model.uml.UMLAttribute;

import java.util.*;

public class CFModel extends NoSQLDataUnit {
  private String cf_name;
  private List<CFColumn> pks;
  private List<CFColumn> cks;
  private List<CFColumn> cols;
  private List<CFColumn> indices;

  public CFModel(){
    cf_name = "";
    pks = new ArrayList<>();
    cks = new ArrayList<>();
    cols = new ArrayList<>();
    indices = new ArrayList<>();
  }

  private class CFColumn{
    private String col_name;
    private String type;
    private boolean isMultiValued;

    private CFColumn(Object o, UMLAttribute attr){
      if(o instanceof QPGNode) {
        col_name = ((QPGNode)o).getNodeName() + "_" + attr.getName();
      }else if (o instanceof QPGEdge){
        col_name = ((QPGEdge)o).getEdgeName() + "_" + attr.getName();
      }
      type = attr.getType();
      isMultiValued = attr.isMultiValued();
    }
  }



  @Override
  public void map(QPGNode root, List<String> agg_labels) {
    // 0- ea,1-ia,2-oa,3-pk, 4-pa, 5-index
    List<Map<Object,Set<UMLAttribute>>> scalarAttrs = new ArrayList<>();// QPGnode or QPGedge-> attributes
    for(int i = 0; i < 6; i++)
      scalarAttrs.add(new HashMap<>());

    int n = 0;
    boolean flag = agg_labels.size()>1;
    for(String agg_label: agg_labels){
      if(n++>0)
        cf_name+= "_";
      cf_name+=agg_label;
      map(root, null, agg_label, scalarAttrs, flag,true);
    }

    for(Object o: scalarAttrs.get(0).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(0).get(o))
        pks.add(new CFColumn(o,attr));
    }
    for(Object o: scalarAttrs.get(1).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(1).get(o))
        cks.add(new CFColumn(o,attr));
    }
    for(Object o: scalarAttrs.get(2).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(2).get(o))
        cks.add(new CFColumn(o,attr));
    }
    for(Object o: scalarAttrs.get(3).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(3).get(o))
        cks.add(new CFColumn(o,attr));
    }
    for(Object o: scalarAttrs.get(4).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(4).get(o)) {
        cols.add(new CFColumn(o, attr));
      }
    }
    for(Object o: scalarAttrs.get(5).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(5).get(o))
        indices.add(new CFColumn(o,attr));
    }
  }

  private void map(QPGNode node, QPGEdge in_edge,
                               String agg_label,List<Map<Object,Set<UMLAttribute>>> scalarAttrs,
                   boolean merging, boolean isRoot){
    Set<UMLAttribute> added = new HashSet<>();
      if(!merging || (merging && isRoot)) {
        if (scalarAttrs.get(0).get(node) == null)
          scalarAttrs.get(0).put(node, new HashSet<>());
        scalarAttrs.get(0).get(node).addAll(node.getEAattrs(agg_label));
        added.addAll(node.getEAattrs(agg_label));
        if(in_edge!= null){
          if (scalarAttrs.get(0).get(in_edge) == null)
            scalarAttrs.get(0).put(in_edge, new HashSet<>());
          scalarAttrs.get(0).get(in_edge).addAll(in_edge.getEAattrs(agg_label));
          added.addAll(in_edge.getEAattrs(agg_label));
        }
      }else {
        for(UMLAttribute a: node.getEAattrs(agg_label)){
          if(scalarAttrs.get(0).get(node) != null && scalarAttrs.get(0).get(node).contains(a))
            continue;
          if (scalarAttrs.get(1).get(node) == null)
            scalarAttrs.get(1).put(node, new HashSet<>());
          scalarAttrs.get(1).get(node).add(a);
        }
        if(in_edge != null){
          for(UMLAttribute a: in_edge.getEAattrs(agg_label)){
            if(scalarAttrs.get(0).get(in_edge) != null && scalarAttrs.get(0).get(in_edge).contains(a))
              continue;
            if (scalarAttrs.get(1).get(in_edge) == null)
              scalarAttrs.get(1).put(in_edge, new HashSet<>());
            scalarAttrs.get(1).get(in_edge).add(a);
          }
        }
      }

      if(scalarAttrs.get(1).get(node) == null)
        scalarAttrs.get(1).put(node, new HashSet<>());
      for(UMLAttribute a: node.getIAattrs(agg_label)){
        if(added.contains(a))
          continue;
        scalarAttrs.get(1).get(node).add(a); added.add(a);
      }

      if(in_edge != null){
        if(scalarAttrs.get(1).get(in_edge) == null)
          scalarAttrs.get(1).put(in_edge, new HashSet<>());
        for(UMLAttribute a: in_edge.getIAattrs(agg_label)){
          if(added.contains(a))
            continue;
          scalarAttrs.get(1).get(in_edge).add(a); added.add(a);
        }
      }

      if(scalarAttrs.get(2).get(node) == null)
        scalarAttrs.get(2).put(node, new HashSet<>());
      for(UMLAttribute a: node.getOAattrs(agg_label)) {
        if(added.contains(a)) continue;
        scalarAttrs.get(2).get(node).add(a); added.add(a);
      }

      if(in_edge != null){
        if(scalarAttrs.get(2).get(in_edge) == null)
          scalarAttrs.get(2).put(in_edge, new HashSet<>());
        for(UMLAttribute a: in_edge.getOAattrs(agg_label)) {
          if(added.contains(a)) continue;
          scalarAttrs.get(2).get(in_edge).add(a); added.add(a);
        }
      }

    if(in_edge == null || in_edge.getCard(node) > 1) {
      if(scalarAttrs.get(3).get(node) == null)
        scalarAttrs.get(3).put(node, new HashSet<>());
      for(UMLAttribute pk_attr: node.getUmlClass().getPks()){
        /*if((scalarAttrs.get(0).get(node) == null || !scalarAttrs.get(0).get(node).contains(pk_attr))
            && !scalarAttrs.get(1).get(node).contains(pk_attr)
            && !scalarAttrs.get(2).get(node).contains(pk_attr))*/
        if(added.contains(pk_attr)) continue;
        scalarAttrs.get(3).get(node).add(pk_attr); added.add(pk_attr);
      }
    }

      if(scalarAttrs.get(4).get(node) == null)
        scalarAttrs.get(4).put(node, new HashSet<>());
      for(UMLAttribute a: node.getPAattrs(agg_label)) {
        if(added.contains(a)) continue;
        /*if((scalarAttrs.get(0).get(node) == null || !scalarAttrs.get(0).get(node).contains(a))
            && !scalarAttrs.get(1).get(node).contains(a)
            && !scalarAttrs.get(2).get(node).contains(a))*/
         scalarAttrs.get(4).get(node).add(a); added.add(a);
      }

      if(in_edge != null){
        if(scalarAttrs.get(4).get(in_edge) == null)
          scalarAttrs.get(4).put(in_edge, new HashSet<>());
        for(UMLAttribute a: in_edge.getPAattrs(agg_label)) {
          if(added.contains(a)) continue;
          scalarAttrs.get(4).get(in_edge).add(a); added.add(a);
        }
      }

      if(in_edge != null) {
        if(scalarAttrs.get(5).get(node) == null)
          scalarAttrs.get(5).put(node, new HashSet<>());
        scalarAttrs.get(5).get(node).addAll(node.getUmlClass().getPks());
      }

    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(agg_label)){
        map(edge.getEndNode(), edge, agg_label, scalarAttrs,merging,false);
      }
    }
  }
  public String genNoSQLScript(){
    String str = "CREATE TABLE if not exists " + cf_name+ "(";
    for(CFColumn col: pks){
      str += col.col_name + " " + col.type + ",\n";
    }
    for(CFColumn col: cks){
      str += col.col_name + " " + col.type + ",\n";
    }
    for(CFColumn col: cols){
      str+= col.col_name + " " + col.type + ",\n";
    }

    str += "PRIMARY KEY (";
    if(!cks.isEmpty())
      str+= "(";
    int n = 0;
    for(CFColumn col: pks){
      if(n++>0)
        str += ",";
      str += col.col_name ;
    }
    str+=")";
    for(CFColumn col: cks){
      str += ","+col.col_name ;
    }
    if(!cks.isEmpty())
      str+= ")";
    str+=")\n WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };\n";

   //" create index if not exists  q4_bids_id on q4 (bids_id);"
    for(CFColumn col: indices) {
      str += " create index if not exists "+ cf_name+"_"+col.col_name + " on " + cf_name +"("+col.col_name+");\n";
    }

    return str;
  }

  public String print(){
    String str = cf_name+ "[((";

    for(CFColumn col: pks){
      str += col.col_name + ",";
    }
    str+=")";
    for(CFColumn col: cks){
      str += col.col_name + ",";
    }
    str+=")";
    for(CFColumn col: cols){
      str+= col.col_name + ",";
    }
    str+="]\n";
    str += genNoSQLScript();
    return str+"\n";
  }

  @Override
  public String getName() {
    return cf_name;
  }
}
