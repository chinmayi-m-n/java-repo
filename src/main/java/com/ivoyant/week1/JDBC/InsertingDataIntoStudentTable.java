package com.ivoyant.week1.JDBC;
import java.sql.*;
public class InsertingDataIntoStudentTable {
    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5432/demo";
        String userName="postgres";
        String pass="1234";
        //creating connection
        Connection con=DriverManager.getConnection(url,userName,pass);
        //creating statement object using connection object
        Statement st=con.createStatement();
        //executing query using statement object
        //inserting tuples to student table
        String sql1="insert into student values(1,'anusha',50)";
        String sql2="insert into student values(2,'amrutha',30)";
        String sql3="insert into student values(3,'bhavya',20)";
        String sql4="insert into student values(4,'bhavana',40)";
        String sql5="insert into student values(5,'bhuvan',27)";
        //executing sql query to insert tuples into table
        st.execute(sql1);
        st.execute(sql2);
        st.execute(sql3);
        st.execute(sql4);
        st.execute(sql5);
        //closing  connection
        con.close();
    }
}
