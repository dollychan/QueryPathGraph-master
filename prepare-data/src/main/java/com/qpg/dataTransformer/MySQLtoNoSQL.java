package com.qpg.dataTransformer;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MySQLtoNoSQL {
  private static Logger logger = Logger.getLogger(MySQLtoNoSQL.class);

  public static String cassandra_type_int = "INT";
  public static String cassandra_type_float = "FLOAT";
  public static String cassandra_type_date = "TIMESTAMP";
  public static String cassandra_type_text = "TEXT";
  private static int thread_num;
  public static Connection[] sql_connection ;
  public static String output_dir;

  public static void  connectMysql(Properties properties) throws Exception{
    String server = properties.getProperty("mysql.server");
    String user = properties.getProperty("mysql.user");
    String pswd = properties.getProperty("mysql.password");
    thread_num = Integer.parseInt(properties.getProperty("thread.num","1"));
    sql_connection = new Connection[thread_num];
    for(int i = 0; i < thread_num; i++)
      sql_connection[i] = DriverManager.getConnection(server, user, pswd);
    output_dir = properties.getProperty("output.dir");
  }

  public static void run(QPGTransformer mappers) throws Exception{
    List<MapperTreeNode> mapper = mappers.getMappers();
    for(MapperTreeNode tn: mapper) {
      if (mappers.getTargetDBType() == QPGTransformer.TargetDB_CF) {
        transformToCF(tn.getNode_name(), tn.getSql_stmt());
      } else if (mappers.getTargetDBType() == QPGTransformer.TargetDB_DOC) {
        tansformToDoc(tn);
      } else if (mappers.getTargetDBType() == QPGTransformer.TargetDB_KV) {

      }
    }
  }
  private static void tansformToDoc(MapperTreeNode root) throws Exception{

    Statement stmt = sql_connection[0].createStatement();
    logger.info("Insert into Doc " + root.getNode_name() + " with:\n " + root.getSql_stmt());
    ResultSet rs = stmt.executeQuery(root.getSql_stmt());

    List<Thread> threads = new ArrayList<>();
    int num_thread = 1;
    //if(root.getNode_name().contains("Customer") || root.getNode_name().contains("Order")) num_thread = thread_num;
    num_thread = thread_num;
    for(int i = 0; i < num_thread; i++)
      threads.add(new Thread(new WriteJSONThread(i, num_thread, rs, root)));
    for(int i = 0; i < num_thread; i++)
      threads.get(i).start();

  }

  private static void transformToCF(String cf_name, String sql) throws Exception{
    Statement stmt = sql_connection[0].createStatement();
    logger.info("Insert into CF " + cf_name + " with:\n " + sql);
    ResultSet rs = stmt.executeQuery(sql);
    writetoCSV(rs, cf_name);
  }

  private static void writetoCSV(ResultSet rs, String cf_name) throws Exception{
    String outputFile = output_dir + cf_name+ ".csv";
    BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

    ResultSetMetaData rmeta = rs.getMetaData();

    String csv_header = "";
    int h_num = 0;
    for(int i = 1; i <= rmeta.getColumnCount(); i++){
      if(h_num++>0)
        csv_header += ",";
      csv_header += rmeta.getColumnLabel(i);
    }
    bw.write(csv_header+"\n");

    while(rs.next()) {
      String row = "";
      int num = 0;
      for(int i = 1; i <= rmeta.getColumnCount(); i++){
        if(num ++ >0)
          row += ",";
        row+= readSQLresult(rs, rmeta.getColumnLabel(i), rmeta.getColumnTypeName(i),i);
      }
      row += "\n";
      bw.write(row);
    }
    bw.close();
  }

  protected static String readSQLresult(ResultSet rs,String col_name, String col_type, int colIndex) throws Exception{
    if(col_type.contains(cassandra_type_int) || col_type.contains("BIT"))  {
      return rs.getInt(colIndex)+"";
    } else if(col_type.contains(cassandra_type_float)){
      return rs.getFloat(colIndex)+"";
    }
    else if(col_type.contains(cassandra_type_text) || col_type.contains("VARCHAR")){
      String text = rs.getString(colIndex);
      text = text.replaceAll("\n"," ");
      return "\""+text+"\"";
    }else if(col_type.contains(cassandra_type_date) || col_type.contains("DATETIME")){
      return "\""+rs.getTimestamp(colIndex)+"\"";
    }else System.err.println("Error CF column "+ col_name + "'s type " + col_type +" mismatch!");
    return "";
  }

}
