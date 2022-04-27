import com.qpg.expr.execplan.QPGExecPlanParser;
import org.junit.Test;

public class TestExecPlanParser {

  @Test
  public void testExecPlanParser() {
    try {
      String path = "src/main/resources/NoSE_Rubis_ExecPlan";

      QPGExecPlanParser.run(path);
    }catch(Exception e){e.printStackTrace();}
  }
}
