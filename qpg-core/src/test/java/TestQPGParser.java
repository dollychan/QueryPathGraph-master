
import com.qpg.model.QPGInput;
import com.qpg.model.qpg.QPGGraph;
import com.qpg.model.qpg.QPGNode;
import com.qpg.parser.QPGWorkloadParser;
import com.qpg.parser.QPGWorkloadVisitor;
import org.antlr.v4.runtime.*;
import org.junit.Test;

import com.qpg.parser.antlr.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestQPGParser {
    String path = "src/main/resources/casestudy/";

    @Test
    public void myTest(){
        Set<String> ss= new HashSet<>();
        ss.add("aaa");
        ss.add("aaa");
        ss.add("bbb");
        Set<String> ss2= new HashSet<>();
        ss2.add("bbb");
        ss2.addAll(ss);
        ss2.contains("ccc");

        Set<Object> sg = new HashSet<>();
        QPGGraph n = new QPGGraph();
        QPGInput i = new QPGInput();
        sg.add(n);
        sg.add(i);
        sg.add(n);
        List<Object> nl = new ArrayList<Object>();
        nl.add(n); nl.add(i);
        for(Object nn: nl)
            if(nn == n){
                System.out.println("aaaaaaaaa");
            }else if(nn == i){
                System.out.println("bbbbbbbbbbb");
            }
    }

    @Test
    public void testQPGWorkloadParser() throws Exception{
        String filename = "onlineStore.info";
        QPGWorkloadParser.run(path+filename);
    }

}
