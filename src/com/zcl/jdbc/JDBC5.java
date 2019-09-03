package com.zcl.jdbc;

import com.zcl.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 通过键盘输入用户名和密码，判断是否登陆成功
 */
public class JDBC5 {
    public boolean login(String name,String password){
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        if(name==null||password==null){
            return false;
        }
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from t_user where name='"+name+"' and password='"+password+"'";
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stat,conn);
        }
        return false;
    }

    public static void main(String[] args) {
        JDBC5 jdbc5=new JDBC5();
//        String name="zcl";
//        String password="12456";
//        if(jdbc5.login(name,password)){
//            System.out.println("success");
//        }else {
//            System.out.println("faild");
//        }
        Scanner sc=new Scanner(System.in);
        System.out.println("input name:");
        String name=sc.nextLine();
        System.out.println("input password");
        String password=sc.nextLine();
        if(jdbc5.login(name,password)){
            System.out.println("success");
        }else {
            System.out.println("faild");
        }

    }
}
