
import java.io.*;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.junit.Test;


public class PropertiesTester  {

  @Test
  public void testLogger() {
    //String log4jConfPath = "src/main/resources/log4j.properties";
    //PropertyConfigurator.configure(log4jConfPath);
    Logger logger = Logger.getLogger(PropertiesTester.class);

    logger.debug("sdddddddd");
    logger.info("dddddddssssss");
  }



  @Test
  public void getPath1() {
    String basePath = "workload.config";
    try {
      InputStream in = new BufferedInputStream(new FileInputStream(
          new File(basePath)));
      Properties prop = new Properties();

      prop.load(in);

      String path = prop.getProperty("path");
      System.out.println(path);
    } catch (FileNotFoundException e) {
      System.out.println("properties文件路径书写有误，请检查！");
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


