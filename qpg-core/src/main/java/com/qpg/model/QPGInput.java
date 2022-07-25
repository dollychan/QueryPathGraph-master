package com.qpg.model;

import com.qpg.model.query.QueryStmt;
import com.qpg.model.uml.UMLClass;
import com.qpg.model.uml.UMLRelationship;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QPGInput {
  private static Logger logger = Logger.getLogger(QPGInput.class);

  private HashMap<String, UMLClass> classList;// class name -> UML class
  private List<QueryStmt> queryList;
  private List<UMLRelationship> relList;
 // private HashMap<String, UpdateStmt> updateList;

  private Map<UMLClass,Double> class_avg_size;
  private Map<Object, Double> workload_freq;// (*QueryStmt, *UMLClass, *UMLREl) -> freq

  public QPGInput(){
    classList = new HashMap<>();
    queryList = new ArrayList<>();
    relList = new ArrayList<>();
    class_avg_size = new HashMap<>();
    workload_freq = new HashMap<>();
  }

  public List<QueryStmt> getQueryList(){return queryList;};
  public void addWorkloadFreq(Object c, double f){
    workload_freq.put(c,f);
  }

  private Map<Object, Double> getWorkloadFreq(){
    if(workload_freq.isEmpty()){
      defaultWorkloadFreq();
    }
    return workload_freq;
  }
  public Double getWorkloadFreq(Object o){
    getWorkloadFreq();
    if(workload_freq.get(o) == null)
      return 0.0;
    return workload_freq.get(o);
  }
  private void defaultWorkloadFreq(){
    for(QueryStmt q: queryList){
      double f = ((double)80)/(double)queryList.size();
      workload_freq.put(q, f);
    }
    int u_n = classList.keySet().size()+ relList.size();
    for(String c: classList.keySet()){
      workload_freq.put(classList.get(c), ((double)20/(double)u_n));
    }
    for(UMLRelationship r: relList)
      workload_freq.put(r, ((double)20/(double)u_n));
  }

  public void addClassSize(UMLClass c, double size){
    class_avg_size.put(c, size);
  }

  public void addClass(UMLClass c){
    if(classList.get(c.getName()) != null){
      System.err.println("Duplicate class "+ c.getName() +"! Please be aware!");
    }
    classList.put(c.getName(), c);
  }

  public UMLClass getClass(String name){
    return classList.get(name);
  }

  public void addQuery(QueryStmt q){
    queryList.add(q);
    q.setQueryName("Q"+queryList.size());
  }

  public void addRel(UMLRelationship rel){
    relList.add(rel);
    if( classList.get(rel.getClass(1)) != null && classList.get(rel.getClass(2)) != null) {
      classList.get(rel.getClass(1)).addRel(rel.getClass(2), rel);
      classList.get(rel.getClass(2)).addRel(rel.getClass(1), rel);
    }else{
      logger.error("Relationship definition should be put after class definitions: "
          + rel.getClass(1) + ", "+rel.getClass(2));
    }
  }

  public UMLRelationship getRel(String src, String relName, String tgt){
    return getClass(src).getUmlRel( relName, tgt);
  }

}
