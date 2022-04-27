package com.qpg.model.query;


import com.qpg.QPGRunner;
import com.qpg.core.QPGGenerator;
import com.qpg.model.QPGInput;

import java.util.*;

import com.qpg.model.qpg.ExecutionPlan;
import com.qpg.model.qpg.QPGEdge;
import com.qpg.model.qpg.QPGGraph;
import com.qpg.model.qpg.QPGNode;
import org.apache.log4j.Logger;

public class QueryStmt {
  private static Logger logger = Logger.getLogger(QueryStmt.class);
  private String q_name;
  private List<ClassAttr> selectProperties;
  private List<ClassAttr> equalityProperties;
  private List<ClassAttr> inequalityProperties;
  private List<ClassAttr> orderProperties;
  private Map<String, String> alias_class; //in cases that alias used in the FROM clause, for cycle
  private Map<String, List<QPEdge>> paths;// class_alias-> (Query Pattern Eges)
  private String ap_class_alias; // pick one as the access point

  public QueryStmt() {
    selectProperties = new ArrayList<>();
    equalityProperties = new ArrayList<>();
    inequalityProperties = new ArrayList<>();
    orderProperties = new ArrayList<>();
    alias_class = new HashMap<>();
    paths = new HashMap<>();
  }
 public void setQueryName(String qn){   this.q_name = qn;}
  public String getQueryName(){return q_name;}
  public void addSelectPro(String class_name, String attr_name){
    selectProperties.add(new ClassAttr(class_name, attr_name));
  }
  public void addEqualityPro(String class_name, String attr_name){
    equalityProperties.add(new ClassAttr(class_name, attr_name));
  }
  public void addInequalityPro(String class_name, String attr_name){
    inequalityProperties.add(new ClassAttr(class_name, attr_name));
  }
  public void addOrderPro(String class_name, String attr_name, String asc_desc){
    orderProperties.add(new ClassAttr(class_name, attr_name, asc_desc));
  }
  public void addAliasClass(String[] e){
    alias_class.put(e[1], e[0]);
  }
  private void addPath(String src, QPEdge e){
    List<QPEdge> edges = paths.get(src);
    if(edges == null)
      edges = new ArrayList<>();
    edges.add(e);
    paths.put(src,edges);
  }
  public void addPath(int eid, String relName, String src, String target){
    addPath(src, new QPEdge(eid, relName,target));
    addPath(target, new QPEdge(eid, relName, src));
  }


  public void genOptimalQueryPath(QPGInput input){
    List<String> candidate = getCandidateAP();
    assert candidate.size() > 1;
    if(candidate.size() == 1) {
      ap_class_alias = candidate.get(0);
      return;
    }
    Map<String, Integer> ap_weight = new HashMap<>(); //alias - weight
    for(String name: candidate){
      ap_weight.put(name, calWeight(name,1, input, new HashSet<Integer>()));
    }
    //pick a minimal one
    Iterator<String> iter = ap_weight.keySet().iterator();
    int min = Integer.MAX_VALUE;
    while(iter.hasNext()){
      String ap = iter.next();
      if(ap_weight.get(ap) < min)
        ap_class_alias = ap;
    }
  }

  //only classes having equality properties are taken as candidate
  private List<String> getCandidateAP(){
    List<String> candidate = new ArrayList<>();
    if(!equalityProperties.isEmpty()){
      for(ClassAttr p: equalityProperties){
        candidate.add(p.class_name);
      }
      return candidate;
    }
    Iterator<String> alias = alias_class.keySet().iterator();
    while(alias.hasNext()){
      candidate.add(alias.next());
    }
    return candidate;
  }

  private int calWeight(String alias_name, int parent_w, QPGInput input, Set<Integer> processed_rels){
    int w = 0;
    List<QPEdge> edges = paths.get(alias_name);
    if(edges == null)
      return w;
    for(QPEdge e : edges) {
      if(processed_rels.contains(e.eid)) {
        continue;
      }
      else
        processed_rels.add(e.eid);
      int c_w = parent_w * input.getClass(alias_class.get(e.target_alias)).getRelCardRatio(e.relName, alias_name);
      w+=c_w;
      w += calWeight(e.target_alias, c_w, input, processed_rels);
    }
    return w;
  }

  private class QPEdge{
    private int eid;
    private String relName;
    private String target_alias;
    private QPEdge(int eid, String relName, String target_alias){
      this.eid = eid;
      this.relName = relName;
      this.target_alias = target_alias;
    }
  }

  private class ClassAttr{
    private String class_name; // alias name
    private String attr_name;
    private String op = "";
    private ClassAttr(String cn, String an, String qo){
      this.class_name = cn;
      this.attr_name = an;
      this.op = qo;
    }
    private ClassAttr(String cn, String an){
      this.class_name = cn;
      this.attr_name = an;
    }
  }

  public QPGNode mapToQPG(String agg_label){
    QPGNode root = mapQPGNode(ap_class_alias);
    root.addPKtoPA(agg_label);

    mapToQPG(agg_label,ap_class_alias, root,new HashSet<Integer>()); // build the tree

    //Add SA specifications
    for(ClassAttr attr: selectProperties){
      if(QPGGenerator.graph.getNode(attr.class_name) != null)
        QPGGenerator.graph.getNode(attr.class_name).addPAattrs(agg_label, attr.attr_name);
      else QPGGenerator.graph.getEdge(attr.class_name).addPAattrs(agg_label,attr.attr_name);
    }
    for(ClassAttr attr: equalityProperties){
      if(QPGGenerator.graph.getNode(attr.class_name) != null)
        QPGGenerator.graph.getNode(attr.class_name).addEAattrs(agg_label, attr.attr_name);
      else QPGGenerator.graph.getEdge(attr.class_name).addEAattrs(agg_label, attr.attr_name);
    }
    for(ClassAttr attr: inequalityProperties){
      if(QPGGenerator.graph.getNode(attr.class_name) != null)
        QPGGenerator.graph.getNode(attr.class_name).addIAattrs(agg_label, attr.attr_name);
      else QPGGenerator.graph.getEdge(attr.class_name).addIAattrs(agg_label, attr.attr_name);
    }
    for(ClassAttr attr: orderProperties){
      if(QPGGenerator.graph.getNode(attr.class_name) != null)
        QPGGenerator.graph.getNode(attr.class_name).addOAattrs(agg_label, attr.attr_name);
      else QPGGenerator.graph.getEdge(attr.class_name).addOAattrs(agg_label, attr.attr_name);
    }
    return root;
  }

  private QPGNode mapQPGNode(String class_alias){
    QPGNode node ;
    if(QPGGenerator.graph.isExists(class_alias))
      node = QPGGenerator.graph.getNode(class_alias);
    else {
      node = new QPGNode(class_alias, QPGRunner.input.getClass(alias_class.get(class_alias)));
      QPGGenerator.graph.addNode(node);
    }
    return node;
  }

  private void mapQPGEdge(String agg_label,
                          String relname,
                          QPGNode startnode, QPGNode endnode){
    QPGEdge edge = startnode.getOutEdge(relname, endnode);
    if(edge == null){
      assert endnode.getInEdge(relname,startnode) == null;
      edge = new QPGEdge(relname, startnode,endnode, agg_label,
          QPGRunner.input.getRel(alias_class.get(startnode.getNodeName()),
               relname, alias_class.get(endnode.getNodeName())));
      startnode.addEdge(edge);
      endnode.addEdge(edge);
      QPGGenerator.graph.addEdge(edge);
    }else{
      edge.addAggLabel(agg_label);
    }
  }

  private void mapToQPG(String agg_label,
                        String parent_class, QPGNode parent,Set<Integer> processed_rels){
    List<QPEdge> edges = paths.get(parent_class);
    if(edges == null) return;
    for(QPEdge e : edges) {
      if(processed_rels.contains(e.eid)) {
        continue;
      }
      else
        processed_rels.add(e.eid);
      QPGNode node = mapQPGNode(e.target_alias);
      node.addPKtoPA(agg_label);
      mapQPGEdge(agg_label, e.relName, parent, node);
      mapToQPG(agg_label,e.target_alias, node, processed_rels);
    }
  }
}
