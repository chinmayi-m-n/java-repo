package com.ivoyant.week2.TransactionManagementInJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTransactionManagement {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/demo";
        String userName="postgres";
        String password="1234";
        Connection con=null;
        try{

             con = DriverManager.getConnection(url, userName, password);
             // disable autocommit
             con.setAutoCommit(false);
            Statement st=con.createStatement();
            String sql="insert into student values(1,'gagan',100)";
            st.execute(sql);
            con.commit();
        }
        catch(Exception e){
            //if exception occurs while creating connection itself con remains null
            if(con==null){
                System.out.println("unable to create connection");
            }
            else{
                //connection has created but execution of query has failed
                try{
                    con.rollback();
                    con.close();
                    System.out.println("unable to insert the tuple hence transaction is rolled back"+e);

                }
                catch(Exception ex){
                    System.out.println("unable to rollback"+ex);
                }
            }
        }
    }
}
