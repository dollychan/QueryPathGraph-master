package com.qpg.model.uml;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class UMLRelationship {
  private static Logger logger = Logger.getLogger(UMLRelationship.class);
  private String name;
  private String class1, class2; // target class name
  private int card_ratio1, card_ratio2;
  //private List<UMLAttribute> attrs;
  private Map<String, UMLAttribute> attrs;

  public UMLRelationship(String name, String class1, int card_ratio1,
                         String class2, int card_ratio2) {
    this.name = name;
    this.class1 = class1;
    this.class2 = class2;
    this.card_ratio1 = card_ratio1;
    this.card_ratio2 = card_ratio2;
  }

  public String getName() {
    return name;
  }
  public String getClass(int i){
    assert i == 1 || i == 2;
    if(i == 1)return class1;
    if(i == 2) return class2;
    return null;
  }

  public int getCardRatio(String cls_name) {
    if (cls_name.equalsIgnoreCase(class1))
      return card_ratio1;
    if (cls_name.equalsIgnoreCase(class2))
      return card_ratio2;
    logger.error("Cannot find Card_ratio for class " + cls_name + "in rel " + name + "!");
    return 0;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void addAttr(UMLAttribute attr){
    if(attrs == null)
      attrs = new HashMap<>();
    attrs.put(attr.getName(),attr);
  }
  public UMLAttribute getAttr(String attr_name){
    if(attrs.get(attr_name) == null)
      logger.error("No attribute" +attr_name + " in relationship " + name+"!");
    return attrs.get(attr_name);
  }

  @Override
  public String toString() {
    return "rel " + name + ":"+class1+"[" + card_ratio1+ "]" +
        " " + class2+"[" + card_ratio2+ "]";
  }

}
