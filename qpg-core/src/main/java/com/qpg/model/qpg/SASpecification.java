package com.qpg.model.qpg;

import com.qpg.model.uml.UMLAttribute;

import java.util.*;

public class SASpecification {
  private Map<String, Set<UMLAttribute>> agg_ea_attrs; // aggregation label -> set of attributes
  private Map<String, Set<UMLAttribute>> agg_ia_attrs; // aggregation label -> set of attributes
  private Map<String, Set<UMLAttribute>> agg_oa_attrs; // aggregation label -> set of attributes
  private Map<String, Set<UMLAttribute>> agg_pa_attrs; // aggregation label -> set of attributes

  protected SASpecification(){
    agg_ea_attrs = new HashMap<>();
    agg_ia_attrs = new HashMap<>();
    agg_oa_attrs = new HashMap<>();
    agg_pa_attrs = new HashMap<>();
  }

  public boolean isUsedInAgg(String al){
    if(agg_ea_attrs.get(al) != null && !agg_ea_attrs.get(al).isEmpty())
      return true;
    if(agg_ia_attrs.get(al) != null && !agg_ia_attrs.get(al).isEmpty())
      return true;
    if(agg_oa_attrs.get(al) != null && !agg_oa_attrs.get(al).isEmpty())
      return true;
    if(agg_pa_attrs.get(al) != null && !agg_pa_attrs.get(al).isEmpty())
      return true;
    return false;
  }
  public void addEAattrs(String agg_label, UMLAttribute attr){
    addSAattrs(agg_label,attr,agg_ea_attrs);
  }
  public void addIAattrs(String agg_label, UMLAttribute attr){
    addSAattrs(agg_label,attr,agg_ia_attrs);
  }
  public void addOAattrs(String agg_label, UMLAttribute attr){
    addSAattrs(agg_label,attr,agg_oa_attrs);
  }
  public void addPAattrs(String agg_label, UMLAttribute attr){
    addSAattrs(agg_label,attr,agg_pa_attrs);
  }
  private void addSAattrs(String agg_label, UMLAttribute attr, Map<String,Set<UMLAttribute>> sa_attrs){
    if(sa_attrs.get(agg_label) == null)
      sa_attrs.put(agg_label,new HashSet<>());
    sa_attrs.get(agg_label).add(attr);
  }

  protected Set<UMLAttribute> getEAattrs(String agg_label){
    if(agg_ea_attrs.get(agg_label) == null)
      return new HashSet<>();
    return agg_ea_attrs.get(agg_label);}
  protected Set<UMLAttribute> getIAattrs(String agg_label){
    if(agg_ia_attrs.get(agg_label) == null)
      return new HashSet<>();
    return agg_ia_attrs.get(agg_label);}
  protected Set<UMLAttribute> getOAattrs(String agg_label){
    if(agg_oa_attrs.get(agg_label) == null)
      return new HashSet<>();
    return agg_oa_attrs.get(agg_label);}
  protected Set<UMLAttribute> getPAattrs(String agg_label){
    if(agg_pa_attrs.get(agg_label) == null)
      return new HashSet<>();
    return agg_pa_attrs.get(agg_label);}

  protected void addAttrsToEA(String agg_label, Set<UMLAttribute> attrs){
    if(agg_ea_attrs.get(agg_label) == null)
      agg_ea_attrs.put(agg_label, new HashSet<>());
    agg_ea_attrs.get(agg_label).addAll(attrs);
  }
  protected void addAttrsToPA(String agg_label, Set<UMLAttribute> attrs){
    if(agg_pa_attrs.get(agg_label) == null)
      agg_pa_attrs.put(agg_label, new HashSet<>());
    agg_pa_attrs.get(agg_label).addAll(attrs);
  }
  protected void changeAggLabel(String old_l, String new_l){
    if( agg_ea_attrs != null)
      changeAgg(old_l,new_l,agg_ea_attrs);
    if( agg_ia_attrs != null)
      changeAgg(old_l,new_l,agg_ia_attrs);
    if( agg_oa_attrs != null)
      changeAgg(old_l,new_l,agg_oa_attrs);
    if( agg_pa_attrs != null)
      changeAgg(old_l,new_l, agg_pa_attrs);
  }
  protected void changeAgg(String old_l, String new_l, Map<String, Set<UMLAttribute>> sa_attrs){
    if(sa_attrs.get(old_l) != null){
      Set<UMLAttribute> attrs = sa_attrs.get(old_l);
      sa_attrs.remove(old_l);
      sa_attrs.put(new_l, attrs);
    }
  }

  public String print(){
    String str = "";
    if(!agg_ea_attrs.isEmpty())
      str += "EA: ["+ printSA(agg_ea_attrs)+"],";
    if(!agg_ia_attrs.isEmpty())
      str += "IA: ["+ printSA(agg_ia_attrs)+"],";
    if(!agg_oa_attrs.isEmpty())
      str += "OA: ["+ printSA(agg_oa_attrs)+"],";
    if(!agg_pa_attrs.isEmpty())
      str += "PA: ["+ printSA(agg_pa_attrs)+"]";
    return str+"\n";
  }

  private String printSA(Map<String, Set<UMLAttribute>> al_attrs){
    String str = "";
    for(String al: al_attrs.keySet()){
      str += al+"-> {" ;
      for(UMLAttribute a: al_attrs.get(al))
        str+= a.getName()+",";
      str+="}, ";
    }
    return str;
  }

  public Set<String> getExecutionPlan(){
    Set<String> execution_plan = new HashSet<>();
    getAllAggLabels(agg_ea_attrs, execution_plan);
    getAllAggLabels(agg_ia_attrs, execution_plan);
    getAllAggLabels(agg_oa_attrs, execution_plan);
    getAllAggLabels(agg_pa_attrs, execution_plan);
    return execution_plan;
  }

  private void getAllAggLabels(Map<String,Set<UMLAttribute>> sa_attrs, Set<String> agg_labels){
    for(String l: sa_attrs.keySet())
      for(UMLAttribute a : sa_attrs.get(l)){
        if(!a.isPrimaryKey()) {
          agg_labels.add(l);
          break;
        }
      }
  }
}
