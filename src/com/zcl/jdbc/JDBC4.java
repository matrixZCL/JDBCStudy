package com.zcl.jdbc;

import com.zcl.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//工具类的使用
public class JDBC4 {

    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from t_person where id =1";
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            System.out.println(rs.next());
            System.out.println(rs.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stat,conn);
        }

    }
}
