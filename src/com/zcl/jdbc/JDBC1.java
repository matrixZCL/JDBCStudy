package com.zcl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC1 {
    public static void main(String[] args)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://47.101.210.40:3306/jdbcstudy","root","123456");
        String sql="update t_person set name = 'shit' where id=1";
        Statement stat=conn.createStatement();
        int count=stat.executeUpdate(sql);
        System.out.println(count);
        stat.close();
        conn.close();

    }
}
