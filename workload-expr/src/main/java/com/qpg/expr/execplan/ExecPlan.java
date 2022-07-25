package com.qpg.expr.execplan;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ExecPlan {
  private static Logger logger = Logger.getLogger(ExecPlan.class);
  public static final String EXECPLAN_ATTR_TYPE_INT = "int";
  public static final String EXECPLAN_ATTR_TYPE_DATE = "timestamp";
  public static final String EXECPLAN_ATTR_TYPE_STRING = "text";
  public static final String EXECPLAN_ATTR_TYPE_FLOAT = "float";
  public static final char EXECPLAN_UPDATE_TYPE_MODIFY = '0';
  public static final char EXECPLAN_UPDATE_TYPE_ADD = '1';

  private Map<String, DataRange> data_ranges;
  private Map<String, String> attr_type; //some necessary data type used by query
  private Map<String, List<QueryExecPlan>> queries;
  private Map<String, List<UpdateExecPlan>> updates;

  public ExecPlan(){
    data_ranges = new HashMap<>();
    queries = new HashMap<>();
    updates = new HashMap<>();
  }

  public void addDataRange(String attr_name, int min, int max){
    data_ranges.put(attr_name, new DataRange(min, max));
  }
  public void addQueryExecPlan(String qn, String tn, List<String> ea,
                               List<String[]> iea,List<String> oa,List<String> pas, Map<String,String> attr_alias ){
    if(queries.get(qn) == null)
      queries.put(qn , new ArrayList<>());
    queries.get(qn).add( new QueryExecPlan(tn, ea, iea, oa, pas, attr_alias));
  }
  public void addQueryExecPlan(String qn,
                               List<String[]> iea){
    if(queries.get(qn) == null)
      queries.put(qn , new ArrayList<>());
    queries.get(qn).add( new QueryExecPlan( iea));
  }

  public void addDataType(String attr, String type){
    if(attr_type == null)
      attr_type = new HashMap<>();
    attr_type.put(attr, type);
  }

  public  Map<String, List<QueryExecPlan>> getQueries(){return queries;}
  public Map<String,List<UpdateExecPlan>> getUpdates(){return updates;}

  public QueryExecPlan getFirstQuery(String test_name){
    if(queries.get(test_name) == null)
      logger.error("Query Pattern "+ test_name + " cannot be found in the exec plan!" );
    return queries.get(test_name).get(0);
  }
  public UpdateExecPlan getFirstUpdate(String test_name){
    if(updates.get(test_name) == null)
      logger.error("Update Pattern "+ test_name + " cannot be found in the exec plan!" );
    return updates.get(test_name).get(0);
  }

  public List<QueryExecPlan> getQuery(String test_name){
    if(queries.get(test_name) == null)
      logger.error("Query Pattern "+ test_name + " cannot be found in the exec plan!" );
    return queries.get(test_name);
  }

  public List<UpdateExecPlan> getUpdate(String test_name){
    if(updates.get(test_name) == null)
      logger.error("Update Pattern "+ test_name + " cannot be found in the exec plan!" );
    return updates.get(test_name);
  }

  public void addUpdateExecPlan(String update_name, String query_table, String update_table,
                                List<String> query_eas,List<String> update_eas,
                               List<String> query_attrs, List<String> update_attrs,  char update_type) {
    if(updates.get(update_name) == null)
      updates.put(update_name, new ArrayList<>());
    updates.get(update_name).add(new UpdateExecPlan(query_table,update_table, query_eas,
        update_eas, query_attrs, update_attrs, update_type));
  }

  public Object getRandomQueryAttrValue(String attr_name){
    String[] attr = attr_name.split("\\.");
    attr_name = attr[attr.length-1];
    if(data_ranges.get(attr_name) != null)
      return data_ranges.get(attr_name).getRandomId();
    String type = attr_type.get(attr_name);
    if(type == null)
      logger.error("Query uses a undefined attr type for "+ attr_name);
    return genRandomValue(type);
  }

  private Object genRandomValue(String attr_type) {
    try{
    if(attr_type == EXECPLAN_ATTR_TYPE_STRING ){
      return "'ThisisrandomString'";
    }else if(attr_type == EXECPLAN_ATTR_TYPE_DATE ) {
      return  (new SimpleDateFormat("yyyy-mm-dd")).parse("2021-12-01");
    }else if(attr_type == EXECPLAN_ATTR_TYPE_FLOAT){
      return (new Random().nextFloat() * 100) ;
    }else if(attr_type == EXECPLAN_ATTR_TYPE_INT ){
      return new Random().nextInt(1000000);
    }}catch (Exception e){
      logger.error(e.getMessage());
    }
    return null;
  }

  public Object getRandomUpdateValue(String attr_name){
    String[] attr = attr_name.split("\\.");
    attr_name = attr[attr.length-1];
    if(data_ranges.get(attr_name) != null)
      return data_ranges.get(attr_name).incrmax() + "";
    else {
      String type = attr_type.get(attr_name);
      if(type == null)
        logger.error("Query uses a undefined attr type for "+ attr_name);
      return genRandomValue(type);
    }
  }

  public class DataRange{
    private int min;
    private int max;
    private DataRange(int min, int max){
      this.min =min;
      this.max = max;
    }
    private int getRandomId(){return ThreadLocalRandom.current().nextInt(min, max);}
    private int incrmax(){ max++; return max;}
  }

  public class QueryExecPlan{
    private String class_name;
    private List<String> eas;
    private List<String[]> ieas; // attr_name, op
    private List<String> oas;
    private List<String> pas;
    private boolean isFilter = false;
    private Map<String,String> attr_alias;
    private QueryExecPlan(String cn, List<String> ea,List<String[]> iea,
                          List<String> oa,List<String> pas , Map<String,String> attr_alias){
      this.class_name = cn;
      this.eas = ea;
      this.ieas = iea;
      this.oas = oa;
      this.pas = pas;
      this.attr_alias = attr_alias;
    }
    private QueryExecPlan(List<String[]> iea){
      this.ieas = iea;
      this.isFilter = true;
    }
    public boolean isFilter(){return isFilter;}
    public String getClass_name(){return class_name;}
    public List<String> getEas() {return eas;}
    public List<String[]> getIeas(){return ieas;}
    public List<String> getOas(){return oas;}
    public List<String> getPas(){return pas;}
    public String getAttrAlias(String attr){
      if(attr_alias== null || attr_alias.get(attr)== null)
        return attr;
      return attr_alias.get(attr);}

    public Map<String, Object> genRandomQueryValues(){
      Map<String,Object> ea_values = new HashMap<>();
      for(String a: eas) {
        Object v = getRandomQueryAttrValue((attr_alias != null && attr_alias.get(a) != null) ? attr_alias.get(a) : a);
        ea_values.put(a, v);
        if(attr_alias != null && attr_alias.get(a) != null) ea_values.put(attr_alias.get(a) , v);
      }
      for(String[] a:ieas)
        ea_values.put(a[0], getRandomQueryAttrValue((attr_alias!= null && attr_alias.get(a[0])!= null)?attr_alias.get(a[0]):a[0]));
      return ea_values;
    }
    public Object getRandomQueryValue(String a){
      return getRandomQueryAttrValue((attr_alias!= null && attr_alias.get(a)!= null)?attr_alias.get(a):a);
    }
  }

  public class UpdateExecPlan{
    private String query_table, update_table;
    private List<String> query_eas, update_eas;
    private List<String> query_attrs, update_attrs; //update_eas matched with query_attrs
    private char update_type;// modify or add
    private UpdateExecPlan(String table1, String table2, List<String> query_eas,List<String> update_eas,
                           List<String> query_attrs, List<String> update_attrs, char update_type){
      this.query_table = table1;
      this.update_table = table2;
      this.query_eas = query_eas;
      this.update_eas = update_eas;
      this.query_attrs = query_attrs;
      this.update_attrs = update_attrs;
      this.update_type = update_type;
    }

    public String getQueryTable(){return query_table;}
    public String getUpdateTable(){return update_table;}
    public List<String> getQueryEAs(){return query_eas;}
    public List<String> getUpdateEAs(){return update_eas;}
    public List<String> getQueryAttrs(){return query_attrs;}
    public List<String> getUpdateAttrs(){return update_attrs;}

    public Map<String,Object> genRandomUpdateValues(){
      Map<String,Object> ea_values = new HashMap<>();
      for(String a: update_attrs)
        ea_values.put(a, getRandomUpdateValue(a));
      if(query_eas == null)
        return ea_values;
      for(String a: query_eas) {
        Object v = getRandomQueryAttrValue(a);
        ea_values.put(a, v);
        String[] as = a.split("\\.");
        if(as.length>1)
          ea_values.put(as[as.length-1], v);
      }
      return ea_values;
    }
    public Object getRandomQueryValue(String a){
      return getRandomQueryAttrValue(a);
    }

  }

}
