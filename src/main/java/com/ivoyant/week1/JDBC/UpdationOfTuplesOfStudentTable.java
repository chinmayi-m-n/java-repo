package com.ivoyant.week1.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdationOfTuplesOfStudentTable {
    public static void main(String[] args) throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String userName="postgres";
        String pass="1234";
        //creating connection
        Connection con= DriverManager.getConnection(url,userName,pass);
        //creating statement object using connection object
        Statement st=con.createStatement();
        String sql="update student set sname='newUpdatedName' where sid=3";
        st.execute(sql);
        con.close();
    }
}
