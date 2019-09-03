package com.zcl.jdbc;

import com.zcl.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC7 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;

        try {
            //获取连接
            conn=JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            String sql1="update t_account set money = money-? where id = ?";
            String sql2="update t_account set money = money+? where id = ?";
            ps1=conn.prepareStatement(sql1);
            ps1.setInt(1,20);
            ps1.setInt(2,1);
            ps2=conn.prepareStatement(sql2);
            ps2.setInt(1,20);
            ps2.setInt(2,2);

            ps1.executeUpdate();
            ps2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(ps1,conn);
            JDBCUtils.close(ps2,null);
        }
    }
}
