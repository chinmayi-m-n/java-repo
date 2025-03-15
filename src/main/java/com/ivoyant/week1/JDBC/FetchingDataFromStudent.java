package com.ivoyant.week1.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class FetchingDataFromStudent {
    public static void main(String[] args) throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String userName="postgres";
        String pass="1234";
        //creating connection
        Connection con= DriverManager.getConnection(url,userName,pass);
        //creating statement object using connection object
        Statement st=con.createStatement();
        //fetches all rows of table
        String sql="select * from student";
        //rs is a cursor pointing to 0th row of fetched data which is in the form of table
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            //next() method will check if next row exists if yes it returns true and moves cursor to next row
            //fetch the data of current row
            int sid=rs.getInt("sid");//fetching data under sid column
            String sname=rs.getString("sname");
            int marks=rs.getInt("marks");
            //displaying data
            System.out.println("sid:"+sid+" , "+"sname:"+sname+"  , marks:"+marks);
        }
        con.close();

    }
}
