package com.zcl.jdbc;

import com.zcl.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC3 {

    public List<Student> findAll(){
        List<Student> list=null;
        Statement stat=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://47.101.210.40:3306/jdbcstudy","root","123456");
            stat=conn.createStatement();
            String sql="select * from t_person";
            rs=stat.executeQuery(sql);
            Student s=null;
            list=new ArrayList<>();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString(2);
                int sex=rs.getInt(3);
                int age=rs.getInt(4);
                String mobile=rs.getString(5);
                String address=rs.getString(6);
                s=new Student();
                s.setId(id);
                s.setName(name);
                s.setSex(sex);
                s.setAge(age);
                s.setMobile(mobile);
                s.setAddress(address);
                list.add(s);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){

        }
        finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        JDBC3 jdbc3=new JDBC3();
        List<Student> list=jdbc3.findAll();
        System.out.println(list);
    }
}
