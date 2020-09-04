package com.allsale.servletProject.utils;



import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {


//    private static DruidDataSource ds = new DruidDataSource();
    private static final Properties PROPERTIES = new Properties();

    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    static {
//        Properties properties = new Properties();
        InputStream inputStream = DBUtils.class.getResourceAsStream("/database.properties");

        try {
            PROPERTIES.load(inputStream);
//            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(PROPERTIES);
            Class.forName(PROPERTIES.getProperty("driver"));
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static Connection getConnection() {

        Connection connection = THREAD_LOCAL.get();
        try {
            if (connection == null){
//                connection = ds.getConnection();
                connection = DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
                THREAD_LOCAL.set(connection);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }

    // 开始
    public static void begin(){
        Connection connection = THREAD_LOCAL.get();
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 提交
    public static  void commit(){
        Connection connection = THREAD_LOCAL.get();

        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeALl(connection,null,null);
        }

    }


    //回滚
    public static void rollback(){
        Connection connection = null;

        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeALl(connection,null,null);
        }

    }


    //全选 关闭
    public static void closeALl(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




}







