package com.qpg.model.qpg;

import com.qpg.core.QPGGenerator;
import com.qpg.model.uml.UMLAttribute;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AggregationTree {
  private static Logger logger = Logger.getLogger(AggregationTree.class);

  private String agg_label;

  private List<UMLAttribute> ea_attrs;
  private List<UMLAttribute> ia_attrs;
  private List<UMLAttribute> oa_attrs;
//  private List<UMLAttribute> pa_attrs;
 // private List<UMLAttribute> pk_attrs;
  private int sa_size ;


  public AggregationTree(String label){
    this.agg_label = label;
    initScalarAttrs();
  }

 // private List<UMLAttribute> getEAattrs(){return ea_attrs;}
 // private List<UMLAttribute> getIAattrs(){return ia_attrs;}
 // private List<UMLAttribute> getOAattrs(){return oa_attrs;}
//  private List<UMLAttribute> getPAattrs(){return pa_attrs;}
  private int getSAsize(){return sa_size;}

  private void initScalarAttrs(){
    ea_attrs = new ArrayList<>();
    ia_attrs = new ArrayList<>();
    oa_attrs = new ArrayList<>();
    QPGNode root = QPGGenerator.agg_ap.get(agg_label);
    initScalarAttrs(root, null);
    sa_size = ea_attrs.size()+ia_attrs.size()+oa_attrs.size();
  }

  private void initScalarAttrs(QPGNode node, QPGEdge in_edge){
    ea_attrs.addAll(node.getEAattrs(agg_label));
    ia_attrs.addAll(node.getIAattrs(agg_label));
    oa_attrs.addAll(node.getOAattrs(agg_label));

    for(QPGEdge edge: node.getOutEdges()){
      if(edge.isInAgg(agg_label)){
        initScalarAttrs(edge.getEndNode(), edge);
      }
    }
  }

  public boolean isKeyCompatible(AggregationTree other){
    List<UMLAttribute> key1 = new ArrayList<>(), key2 = new ArrayList<>();
    if(sa_size <= other.sa_size){
      key1.addAll(ea_attrs); key1.addAll(ia_attrs);key1.addAll(oa_attrs); //smaller
      key2.addAll(other.ea_attrs); key2.addAll(other.ia_attrs);key2.addAll(other.oa_attrs);//larger
    }else{
      key2.addAll(ea_attrs); key2.addAll(ia_attrs);key2.addAll(oa_attrs); //larger
      key1.addAll(other.ea_attrs); key1.addAll(other.ia_attrs);key1.addAll(other.oa_attrs);//smaller
    }

    for(int i = 0; i < key1.size(); i++){
      if(key1.get(i) != key2.get(i))
        return false;
    }
    return true;
  }

}
