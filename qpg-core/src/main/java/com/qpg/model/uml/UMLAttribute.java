package com.qpg.model.uml;


public class UMLAttribute  {
  private String name;
  private String type;
  private boolean isPrimaryKey;
  private boolean isMultiValued;

  public UMLAttribute(String name, String type, boolean isPrimaryKey, boolean isMultiValued) {
    this.name = name;
    this.type = type;
    this.isPrimaryKey = isPrimaryKey;
    this.isMultiValued = isMultiValued;
  }
  public String getName(){return name;}
  public boolean isPrimaryKey(){return isPrimaryKey;}
  public String getType(){return type;}
  public boolean isMultiValued(){return isMultiValued;}


}
