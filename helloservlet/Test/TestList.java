import com.waston.uitl.JDBCUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @Description:
 * @Author: Waston
 * @Date: 2019/8/1 17:39
 */
public class TestList {
    @Test
    public void test(){
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            //建立连接
            //加载驱动类
            connection = JDBCUtils.getConnection();
            //SQL注入
            statement = connection.createStatement();
            //connection = JDBCUtils.getConnection();
            //SQL注入
            String sql = "select * from books";


            //Result封装查询后的结果
            result = statement.executeQuery(sql);
            while (result.next()){
                System.out.print("ID "+result.getObject("id")+", ");
                System.out.print("USERNAME "+result.getObject("name")+", ");
                System.out.print("PASSWORD "+result.getObject("price")+", ");
                System.out.print("PASSWORD "+result.getObject("author")+", ");
                System.out.print("PASSWORD "+result.getObject("pubDate")+", ");
                System.out.println();
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources();
        }
    }
}
