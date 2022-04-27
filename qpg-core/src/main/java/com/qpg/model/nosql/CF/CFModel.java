package com.qpg.model.nosql.CF;

import com.qpg.model.nosql.NoSQLDataUnit;
import com.qpg.model.qpg.AggregationTree;
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

    private CFColumn(String class_name, UMLAttribute attr){
      col_name = class_name+"_"+attr.getName();
      type = attr.getType();
      isMultiValued = attr.isMultiValued();
    }
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
    return str;
  }

  @Override
  public void map(QPGNode root, List<String> agg_labels) {
    // 0- ea,1-ia,2-oa,3-pk, 4-pa, 5-index
    List<Map<QPGNode,Set<UMLAttribute>>> scalarAttrs = new ArrayList<>();
    for(int i = 0; i < 6; i++)
      scalarAttrs.add(new HashMap<>());

    int n = 0;
    for(String agg_label: agg_labels){
      if(n++>0)
        cf_name+= "_";
      cf_name+=agg_label;
      map(root, null, agg_label, scalarAttrs);
    }

    for(QPGNode node: scalarAttrs.get(0).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(0).get(node))
        pks.add(new CFColumn(node.getNodeName(),attr));
    }
    for(QPGNode node: scalarAttrs.get(1).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(1).get(node))
        cks.add(new CFColumn(node.getNodeName(),attr));
    }
    for(QPGNode node: scalarAttrs.get(2).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(2).get(node))
        cks.add(new CFColumn(node.getNodeName(),attr));
    }
    for(QPGNode node: scalarAttrs.get(3).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(3).get(node))
        cks.add(new CFColumn(node.getNodeName(),attr));
    }
    for(QPGNode node: scalarAttrs.get(4).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(4).get(node)) {
        cols.add(new CFColumn(node.getNodeName(), attr));
      }
    }
    for(QPGNode node: scalarAttrs.get(5).keySet()) {
      for(UMLAttribute attr: scalarAttrs.get(5).get(node))
        indices.add(new CFColumn(node.getNodeName(),attr));
    }
  }

  private void map(QPGNode node, QPGEdge in_edge,
                               String agg_label,List<Map<QPGNode,Set<UMLAttribute>>> scalarAttrs){

      if(scalarAttrs.get(0).get(node) == null)
        scalarAttrs.get(0).put(node, new HashSet<>());
      scalarAttrs.get(0).get(node).addAll(node.getEAattrs(agg_label));

      if(scalarAttrs.get(1).get(node) == null)
        scalarAttrs.get(1).put(node, new HashSet<>());
      scalarAttrs.get(1).get(node).addAll(node.getIAattrs(agg_label));

      if(scalarAttrs.get(2).get(node) == null)
        scalarAttrs.get(2).put(node, new HashSet<>());
      scalarAttrs.get(2).get(node).addAll(node.getOAattrs(agg_label));

      if(scalarAttrs.get(4).get(node) == null)
        scalarAttrs.get(4).put(node, new HashSet<>());
      for(UMLAttribute a: node.getPAattrs(agg_label)) {
        if(!scalarAttrs.get(0).get(node).contains(a)
            && !scalarAttrs.get(1).get(node).contains(a)
            && !scalarAttrs.get(2).get(node).contains(a))
         scalarAttrs.get(4).get(node).add(a);
      }

      if(in_edge == null || in_edge.getCard(node) > 1) {
        if(scalarAttrs.get(3).get(node) == null)
          scalarAttrs.get(3).put(node, new HashSet<>());
        for(UMLAttribute pk_attr: node.getUmlClass().getPks()){
          if(!scalarAttrs.get(0).get(node).contains(pk_attr)
              && !scalarAttrs.get(1).get(node).contains(pk_attr)
              && !scalarAttrs.get(2).get(node).contains(pk_attr))
            scalarAttrs.get(3).get(node).add(pk_attr);
          if(scalarAttrs.get(4).get(node).contains(pk_attr))
            scalarAttrs.get(4).get(node).remove(pk_attr);
        }
      }
      if(in_edge != null) {
        if(scalarAttrs.get(5).get(node) == null)
          scalarAttrs.get(5).put(node, new HashSet<>());
        scalarAttrs.get(5).get(node).addAll(node.getUmlClass().getPks());
      }

    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(agg_label)){
        map(edge.getEndNode(), edge, agg_label, scalarAttrs);
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

    return str;
  }
}
