package com.zcl.jdbc;

import java.sql.*;

public class JDBC2 {
    public static void main(String[] args){
        Statement stat=null;
        Connection conn=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //String sql="insert into t_person values(null,'dog',1,22,'13333','ddd')";
            //String sql="delete from t_person where id =1";
            String sql="select * from t_person";
            conn=DriverManager.getConnection("jdbc:mysql://47.101.210.40:3306/jdbcstudy","root","123456");
            stat=conn.createStatement();
            //stat.executeUpdate(sql);
            rs=stat.executeQuery(sql);

            while(rs.next()){
                int a=rs.getInt(1);
                String b=rs.getString("name");
                System.out.println(a+""+b);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {

                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
    }
}
