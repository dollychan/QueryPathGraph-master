package com.qpg.expr.execplan;

import com.qpg.expr.execplan.parser.ExecPlanLexer;
import com.qpg.expr.execplan.parser.ExecPlanParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;

public class QPGExecPlanParser {
  private static Logger logger = Logger.getLogger(QPGExecPlanParser.class);
  public static ExecPlan run(String filepath) {
    ExecPlan execPlan = null;
    try {
      CharStream i = CharStreams.fromFileName(filepath);
      ExecPlanLexer l = new ExecPlanLexer(i);
      ExecPlanParser p = new ExecPlanParser(new CommonTokenStream(l));
      ExecPlanParser.InputContext tree = p.input();

      MyExecPlanVisitor visitor = new MyExecPlanVisitor();
      visitor.visitInput(tree);
      execPlan = visitor.getExecPlan();
    }catch(Exception e){logger.error(e.getMessage());}
    return execPlan;
  }
}
