package com.qpg.core;

import com.qpg.QPGRunner;
import com.qpg.model.common.Keyword;
import com.qpg.model.nosql.CF.CFModel;
import com.qpg.model.nosql.Doc.DocModel;
import com.qpg.model.nosql.NoSQLDataUnit;
import com.qpg.model.nosql.NoSQLSchema;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseGenerator {
  private static Logger logger = Logger.getLogger(DatabaseGenerator.class);
  public static Map<String,String> agg_nosql = new HashMap<>(); //agg_label-> cf/dc name

  public static void maptoNoSQL( List<List<String>> agg_groups) {
    NoSQLSchema noSQLSchema = new NoSQLSchema("NoSQL_schema");
    for(List<String> aggs: agg_groups){
      NoSQLDataUnit du = getDataUnit();
      du.map(QPGGenerator.agg_ap.get(aggs.get(0)), aggs);
      noSQLSchema.addDataUnitSchema(du);
      for(String al: aggs){
        agg_nosql.put(al, du.getName());
      }
    }
    logger.info(noSQLSchema.print());
  }

  ////////////////////////////////////////////////////////////
  private static NoSQLDataUnit getDataUnit(){
    if(QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_CF) {
      CFModel cfs = new CFModel();
      return cfs;
    }
    else if(QPGRunner.nosql_type == Keyword.TARGET_NOSQL_TYPE_DOC) {
      DocModel doc = new DocModel();
      return doc;
    }
    else return null;
  }

}
