package com.waston.uitl;

import com.waston.uitl.CommUtils;

import java.sql.*;
import java.util.Properties;

/**
 * @Description: JDBC操作的公共方法
 * @Author: Waston
 * @Date: 2019/7/30 19:35
 */
public class JDBCUtils {
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;

    static ResultSet resultSet = null;
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;


    static {
        Properties properties = CommUtils.loadProperties("db.properties");
        driverName = properties.getProperty("driverName");
        url = properties.getProperty("url");
        username = properties.getProperty("userName");
        password = properties.getProperty("password");
        //加载驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("获取数据库连接出错");
        }
        return null;
    }

    /**
     * 关闭
     */
    public static void closeResources(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    //更新
    public int executeUpdate(String sql,Object...objects){
        Connection connection =  this.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if(objects != null){
                for(int i = 0;i < objects.length;i++){
                    ps.setObject(i+1,objects[i]);
                }
                return ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResources();
        }
        return -1;
    }

    //查询
    public ResultSet executeQuery(String sql,Object...objects){
        Connection connection =  this.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if(objects != null){
                for(int i = 0;i < objects.length;i++){
                    ps.setObject(i+1,objects[i]);
                }

                return resultSet = ps.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
