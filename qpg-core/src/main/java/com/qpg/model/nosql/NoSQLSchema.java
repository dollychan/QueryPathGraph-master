package com.qpg.model.nosql;

import java.util.ArrayList;
import java.util.List;

public class NoSQLSchema {
  private String ks; // keyspace name for CF and KV; database name for document;
  private List<NoSQLDataUnit> data; // name- KV pair; table name -> CF; collection name -> doc;


  public NoSQLSchema(String ks){
    this.ks = ks;
    data = new ArrayList<>();
  }

  public void addDataUnitSchema(NoSQLDataUnit du){
    data.add(du);
  }

  public String print(){
    String str = "";
    for(NoSQLDataUnit du: data){
      str += du.print();
    }
    return str;
  }

}
