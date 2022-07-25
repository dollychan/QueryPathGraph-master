package com.qpg;

import com.qpg.core.DatabaseGenerator;
import com.qpg.core.QPGGenerator;
import com.qpg.model.QPGInput;
import com.qpg.model.common.Keyword;
import com.qpg.parser.QPGWorkloadParser;
import org.apache.log4j.Logger;

import java.util.List;

public class QPGRunner {
  private static Logger logger = Logger.getLogger(QPGRunner.class);
  public static QPGInput input;
  public static char nosql_type;

  public static void main(String[] args) {
    try{
      String file = "qpg-core/src/main/resources/casestudy/Rubis_bidding.info";
      nosql_type = Keyword.TARGET_NOSQL_TYPE_DOC;
      run(file);
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
  private static void run(String inputFile ) throws Exception{
    //1. input parser
    input = QPGWorkloadParser.run(inputFile);

    //2. generate QPG, QPG generator, determine the access point and edge direction for each query
    QPGGenerator generator = new QPGGenerator();
    generator.init();
    generator.print();
    //3. normalization and merge
    List<List<String>> agg_groups = generator.optimize();
    System.out.println("********************* After optimization *************************");
    generator.print();

    //3. map to specific NoSQL logical model DatabaseGenerator
     DatabaseGenerator.maptoNoSQL(agg_groups);
     logger.info(QPGGenerator.executionPlan.printNoSQLPlan());


  }
}
