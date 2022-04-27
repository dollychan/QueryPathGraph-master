package com.qpg.dataTransformer;

import com.qpg.dataTransformer.parser.MapperLexer;
import com.qpg.dataTransformer.parser.SQLtoNoSQLMapper;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.slf4j.ILoggerFactory;

import java.io.*;
import java.util.Properties;

public class TransformerMain {

  public static void main(String[] args) throws Exception{
    String config_file;
    if(args.length>0)
      config_file = args[0];
    else config_file = "prepare-data/src/main/resources/mysql.config";
    InputStream in = new BufferedInputStream(new FileInputStream(new File(config_file)));
    Properties properties = new Properties();
    properties.load(in);

    MySQLtoNoSQL.connectMysql(properties);
    String sql_dir = properties.getProperty("sql.dir");

    QPGTransformer mappers = run(sql_dir);
    MySQLtoNoSQL.run(mappers);
  }

  public static QPGTransformer run(String filepath) throws Exception{
    CharStream i = CharStreams.fromFileName(filepath);
    MapperLexer l = new MapperLexer(i);
    SQLtoNoSQLMapper p = new SQLtoNoSQLMapper(new CommonTokenStream(l));
    SQLtoNoSQLMapper.InputContext tree = p.input();

    QPGTransformerVisitor visitor = new QPGTransformerVisitor();
    visitor.visitInput(tree);
    return visitor.getTransformer();
  }

}
