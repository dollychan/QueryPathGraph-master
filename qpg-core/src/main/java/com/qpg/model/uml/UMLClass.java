package com.qpg.model.uml;

import org.apache.log4j.Logger;

import java.util.*;

public class UMLClass {
  private static Logger logger = Logger.getLogger(UMLClass.class);
  private String name;
  private Map<String, UMLAttribute> attrs;
  private Set<UMLAttribute> pks;
  private Map<String, UMLRelationship> rels; //rel_name+target_class -> UMLRelationship
//  private double frequency = 1.0;
 // private int avg_size = 1;

  public UMLClass(String name) {
    this.name = name;
    attrs = new HashMap<>();
    pks = new HashSet<>();
    rels = new HashMap<>();
  }

 // public void setFreq(double freq){ this.frequency = freq;}
  //public void setAvgSize(int avg_size){this.avg_size = avg_size;}
  public String getName() {
    return name;
  }
 // public int getAvgSize(){return this.avg_size;}
 // public double getFrequency(){return frequency;}

  public UMLRelationship getUmlRel(String relName, String target){return rels.get(relName+target);}

  public int getRelCardRatio(String relName, String target){
    UMLRelationship rel = rels.get(relName+target);
    if(rel != null)
      return rel.getCardRatio(target);
    System.err.println("UML relation "+relName +"_"+target+ " is not found in class "+name+"!" );
    return 0;
  }

  public void addAttr(UMLAttribute attr){
    attrs.put(attr.getName(),attr);
    if(attr.isPrimaryKey())
      pks.add(attr);
  }

  public UMLAttribute getAttr(String attr_name){return attrs.get(attr_name);}
  public Set<UMLAttribute> getPks(){return pks;}

  public void addRel(String tgt, UMLRelationship rel){
    if(rels.get(rel.getName()+tgt) != null)
      logger.error("Rel "+ rel.getName() + "_" + tgt +" already existed!");
    rels.put(rel.getName()+tgt,rel);
  }
}
