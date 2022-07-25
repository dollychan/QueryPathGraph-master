package com.qpg.dataTransformer;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteJSONThread implements Runnable{
  private static Logger logger = Logger.getLogger(WriteJSONThread.class);

  private int current_thread, thread_num;
  private ResultSet rs;
  private MapperTreeNode root;

  protected WriteJSONThread(int current_thread, int thread_num, ResultSet rs, MapperTreeNode root){
    this.current_thread = current_thread;
    this.thread_num = thread_num;
    this.rs = rs;
    this.root = root;
  }
  @Override
  public void run() {
    Long st = System.currentTimeMillis();
    logger.info("Thread " + current_thread + " running!");
    try {
      String outputFile = MySQLtoNoSQL.output_dir + root.getNode_name() + "_" + current_thread + ".json";
      BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
      ResultSetMetaData rmeta = rs.getMetaData();
      while (true) {
        int num = 0;
        List<MapperTreeNode> children = root.getChildren();
        Map<String,String> bound_values = new HashMap<>();
        synchronized (rs) {
          if(!rs.next())
            break;
        /*if(rs.getRow() % thread_num != current_thread)
          continue;*/
          logger.info("Thread "+root.getNode_name()+"-"+current_thread + " processes Row " + rs.getRow() +"." );
          bw.write("{");
          for (int i = 1; i <= rmeta.getColumnCount(); i++) {
            if (num++ > 0)
              bw.write(",\n");
            bw.write("\"" + rmeta.getTableName(i) + "_" + rmeta.getColumnName(i) + "\""
                + ":" + MySQLtoNoSQL.readSQLresult(rs, rmeta.getColumnLabel(i), rmeta.getColumnTypeName(i),i) + "");
          }
          for (MapperTreeNode cn : children) {
            List<String> bound_attrs = cn.getBoundAttrs();
            if (bound_attrs == null)
              logger.error("Query " + cn.getSql_stmt() + " Not Complete!");
            for (int i = 0; i < bound_attrs.size(); i++)
              bound_values.put(bound_attrs.get(i), rs.getInt(bound_attrs.get(i)) + "");
          }
        }
        for (MapperTreeNode cn : children) {
          if (num++ > 0)
            bw.write(",\n");
          bw.write("\"" + cn.getNode_name() + "\":");
          if (cn.isList())
            bw.write("[\n");
          PreparedStatement stmt = MySQLtoNoSQL.sql_connection[current_thread].prepareStatement(cn.getSql_stmt());
          List<String> bound_attrs = cn.getBoundAttrs();
          for (int i = 0; i < bound_attrs.size(); i++)
            stmt.setString(i + 1, bound_values.get(bound_attrs.get(i)));
          logger.info("Embedded document: " + stmt.toString());
          ResultSet crs = stmt.executeQuery();
          wrtiteToJSON(crs, cn, bw);
          if (cn.isList())
            bw.write("]");
        }
        bw.write("}\n");
      }
      bw.close();
      logger.info("Thread "+root.getNode_name()+"-"+current_thread +"Time spent:" + (System.currentTimeMillis() - st));
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }
  private void wrtiteToJSON(ResultSet rs, MapperTreeNode parent, BufferedWriter bw) throws Exception {
    ResultSetMetaData rmeta = rs.getMetaData();
    int num_ele = 0;
    while (rs.next()) {
      if (num_ele++ > 0)
        bw.write(",\n");
      bw.write("{");
      int num = 0;
      for (int i = 1; i <= rmeta.getColumnCount(); i++) {
        if (num++ > 0)
          bw.write(",\n");
        bw.write("\"" + rmeta.getTableName(i) + "_" + rmeta.getColumnName(i) + "\""
            + ":" + MySQLtoNoSQL.readSQLresult(rs, rmeta.getColumnLabel(i), rmeta.getColumnTypeName(i),i) + "");
      }
      List<MapperTreeNode> children = parent.getChildren();
      for (MapperTreeNode cn : children) {
        if (num++ > 0)
          bw.write(",\n");
        bw.write("\"" + cn.getNode_name() + "\":");
        if (cn.isList())
          bw.write("[\n");
        PreparedStatement stmt = MySQLtoNoSQL.sql_connection[current_thread].prepareStatement(cn.getSql_stmt());
        List<String> bound_attrs = cn.getBoundAttrs();
        if (bound_attrs == null)
          logger.error("Query " + cn.getSql_stmt() + " Not Complete!");
        for (int i = 0; i < bound_attrs.size(); i++)
          stmt.setString(i + 1, rs.getInt(bound_attrs.get(i)) + "");
        logger.info("Embeded document: " + stmt.toString());
        ResultSet crs = stmt.executeQuery();
        wrtiteToJSON(crs, cn, bw);
        if (cn.isList())
          bw.write("]");
      }
      bw.write("}");
    }
  }
}
