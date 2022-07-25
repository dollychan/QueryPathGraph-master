package com.qpg.parser;

import com.qpg.model.QPGInput;
import com.qpg.parser.antlr.WorkloadLexer;
import com.qpg.parser.antlr.WorkloadParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class QPGWorkloadParser {
  public static QPGInput run(String filepath) throws Exception{
    CharStream i = CharStreams.fromFileName(filepath);
    WorkloadLexer l = new WorkloadLexer(i);
    WorkloadParser p = new WorkloadParser(new CommonTokenStream(l));
    WorkloadParser.InputContext tree = p.input();

    QPGWorkloadVisitor visitor = new QPGWorkloadVisitor();
    visitor.visitInput(tree);
    return visitor.getQpgInput();
  }
}