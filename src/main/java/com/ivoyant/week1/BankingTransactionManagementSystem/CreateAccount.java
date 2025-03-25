package com.ivoyant.week1.BankingTransactionManagementSystem;

import java.sql.*;

public class CreateAccount {
    public void createAccount(String name,String address,Long phone,String password){
        //same insert query is be executed every time with different values
        //hence use prepared statement
        //create a connection
        String url="jdbc:postgresql://localhost:5432/BankDB";
        String uname="postgres";
        String pass="1234";
        Connection con=null;
        try {
            con=DriverManager.getConnection(url,uname,pass);
        } catch (SQLException e) {
            System.out.println("sorry not able to connect with database at this time");
            System.exit(0);
        }
        long accountNo=1;
        //account number should also be inserted
        //get previous account number increment it add it as current account number
        try {
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql="select * from users";
            ResultSet rs=st.executeQuery(sql);
            //resultant table has all tuples
            //rs.last() return false if table is empty
            //else it moves cursor to last row and returns true
            if(rs.last()){
                //now cursor is at last row fetch account number in that row
                long lastAccNo=rs.getLong("accountnum");
                accountNo=lastAccNo+1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql="insert into users (accountnum,name,address,phone,password,balance) values (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setLong(1,accountNo);
            pstmt.setString(2,name);
            pstmt.setString(3,address);
            pstmt.setLong(4,phone);
            pstmt.setString(5,password);
            pstmt.setLong(6,1000);
            pstmt.execute();
            System.out.println("account created successfully");
            System.out.println("account number: "+accountNo);
            System.out.println("password: "+password);
            System.out.println("name: "+name);
            System.out.println("phone: "+phone);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
