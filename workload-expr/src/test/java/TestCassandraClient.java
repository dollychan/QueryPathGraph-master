/*
import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.junit.Before;
import org.junit.Test;
import site.ycsb.ByteArrayByteIterator;
import site.ycsb.ByteIterator;
import site.ycsb.NumericByteIterator;
import site.ycsb.StringByteIterator;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestCassandraClient {
  private  Cluster cluster = null;
  private  Session session = null;

  @Before
  public void connect(){
    cluster = Cluster.builder().withPort(Integer.valueOf(9042))
        .addContactPoints("localhost").build();
    session = cluster.connect("rubis_nose");
  }

  @Test
  public void testByteIterator(){
    Map<String, String> input = new HashMap<String, String>();
    input.put("field0", "1");
    input.put("field1", "value2");


    */
/*Map<String, ByteIterator> ii = StringByteIterator.getByteIteratorMap(input);
    ii.put("field3",new NumericByteIterator(1999999999));
    Map<String, String> output = StringByteIterator.getStringMap(ii);*//*

  }

  @Test
  public void testInsert() throws Exception{
    String table = "i2653317939";
    Insert insertStmt = QueryBuilder.insertInto(table);
    insertStmt.value("users_id",1);
   insertStmt.value("buynow_date", (new SimpleDateFormat("yyyy-MM-dd")).parse("2020-02-03"));
    insertStmt.value("buynow_id", 1111);
    insertStmt.value("items_id", 9999);
    session.execute(insertStmt);
  }

  @Test
  public void testRead(){
    String table = "i2653317939";
    Select.Builder selectBuilder = QueryBuilder.select().all();
   // List<String> a = new ArrayList<>(); a.add("users_id");// a.add("buynow_date");
   // List<Object> v = new ArrayList<>(); v.add(59776); // v.add("2021-06-06 12:59:17");
    String sss = selectBuilder.from(table).where(QueryBuilder.eq("users_id",59776)).limit(1).toString();

    //PreparedStatement stmt = session.prepare(selectBuilder.from(table).where(QueryBuilder.eq(a,v))
       // .where(QueryBuilder.eq("users_id",QueryBuilder.bindMarker()))
        //.and(QueryBuilder.gt("buynow_date", "2020-02-2"))
      //  .limit(1));
    int i = 59776;
    //BoundStatement bstmt = stmt.bind();
   */
/* ByteIterator bi = new NumericByteIterator(1);
    if(bi instanceof  NumericByteIterator){
      bstmt = stmt.bind(bi.toArray());
    }else bstmt = stmt.bind(bi.toString());*//*

   */
/* ResultSet rs = session.execute(sss);
    Row row = rs.one();
    row.getDate("buynow_date");
    ByteBuffer bb = row.getBytesUnsafe("buynow_date");
    ByteIterator bi = new ByteArrayByteIterator(bb.array());
    String s = bi.toString();*//*

  }
}
*/
