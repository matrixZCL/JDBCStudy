package com.zcl.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static{
        try {
            Properties pro=new Properties();
            ClassLoader classLoader=JDBCUtils.class.getClassLoader();
            URL res= classLoader.getResource("jdbc.properties");
            String path=res.getPath();
            //System.out.println(path);
            pro.load(new FileReader(path));
            url =pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement s,Connection c){
        if(s!=null){
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(c!=null){
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void close(ResultSet rs,Statement s, Connection c){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(s!=null){
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(c!=null){
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
