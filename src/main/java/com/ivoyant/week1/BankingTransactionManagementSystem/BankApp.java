package com.ivoyant.week1.BankingTransactionManagementSystem;
import java.sql.*;
import java.util.*;
import java.sql.Date;

public class BankApp {
    public static void main(String[] args) {
        //1.create account
        //2.login
        System.out.println("enter 1 to create account \n enter 2 to login");
        Scanner sc=new Scanner(System.in);
        int choice=Integer.parseInt(sc.nextLine());
        if(choice==1){
            //create account
            //by taking "username" "address" "phone number" from user as input
            System.out.println("enter your name");
            String name=sc.nextLine();
            System.out.println("enter your address");
            String address=sc.nextLine();
            System.out.println("enter your phone number");
            long phone=sc.nextLong();
            System.out.println("enter password");
            String password=sc.next();
            CreateAccount acc=new CreateAccount();
            acc.createAccount(name,address,phone,password);
        }
        else if(choice==2){
            //authenticate user using his account number and password
            System.out.println("enter your account number");
            long accountNo=sc.nextLong();
            System.out.println("enter your password");
            String passwrd=sc.next();
            //fetch all tuples from table
            String url="jdbc:postgresql://localhost:5432/BankDB";
            String uname="postgres";
            String pass="1234";
            Connection con=null;
            try {
                con=DriverManager.getConnection(url,uname,pass);
                String sql="select * from users where accountnum=? and password=?";
                PreparedStatement ptmt=con.prepareStatement(sql);
                ptmt.setLong(1,accountNo);
                ptmt.setString(2,passwrd);
                ResultSet rs=ptmt.executeQuery();
                //check if resultset has some tuples
                if(rs.isBeforeFirst()==false){
                    System.out.println("invalid credentials");
                }
                else{
                    //as user is a valid user allow him to perform below operations
                    //1.view transaction history
                    //2.make transaction
                    //3.balance enquiry
                    System.out.println("login successfull");
                    System.out.println("enter \n 1 to view transaction history \n  2 to make transaction  \n 3 for balance enquiry ");
                    int ch=sc.nextInt();
                    if(ch==1){
                       //fetch all tuples from transations table with accountNumber==user entered account number
                       //reusing same statement object
                        String query="select * from transactions where senderaccount=? or receiveraccount=?";
                        ptmt=con.prepareStatement(query);
                        ptmt.setLong(1,accountNo);
                        ptmt.setLong(2,accountNo);
                        rs=ptmt.executeQuery();
                        while(rs.next()){
                            long tId=rs.getLong("transactionid");
                            long senderAccount=rs.getLong("senderaccount");
                            long receiverAccount=rs.getLong("receiverAccount");
                            long amount=rs.getLong("amount");
                            Date date=rs.getDate("dateoftransaction");
                            //if current user accountnumber is at under senderaccount column then amount is debited from current user's account
                            //else amount is credited to user's account
                            if(accountNo==senderAccount){
                                //in this transaction user has sent amount
                                System.out.println(amount+" rupees  sent to account number "+receiverAccount+" on "+date);
                            }
                            else{
                                System.out.println(amount+" rupess received from "+receiverAccount+" on "+date);
                            }
                        }
                    }
                    else if(ch==2){
                        //make transaction
                        //transaction is not possible is user tries to transfer amount> available balance
                        //read receiver's account number
                        System.out.println("enter receiver's account number");
                        long receiver=sc.nextLong();
                        System.out.println("enter the amount is to be transferred");
                        long amount=sc.nextLong();
                        //get balance of the user
                        String q1="select * from users where accountNum=?";
                        ptmt=con.prepareStatement(q1);
                        ptmt.setLong(1,accountNo);
                        rs=ptmt.executeQuery();
                        rs.next();
                        long balance=rs.getLong("balance");
                        if(amount>balance){
                            System.out.println("you don't have suffient balance to make this transaction");
                        }
                        else {
                            //check if receiver's bank account exists
                            q1="select * from users where accountNum=?";
                            ptmt=con.prepareStatement(q1);
                            ptmt.setLong(1,receiver);
                            rs=ptmt.executeQuery();


                            if(rs.next()==false){
                                //resultset is empty
                                System.out.println("receivers account doesnot exists");
                                System.exit(0);
                            }
                            else{
                                //transaction is possible
                                con.setAutoCommit(false);
                                //deduct amount from accountNo's balance
                                //add amount to receiver's balance
                                try{
                                    long senderBalance=balance-amount;
                                    q1="update users set balance=? where accountNum=?";
                                    ptmt=con.prepareStatement(q1);
                                    ptmt.setLong(1,senderBalance);
                                    ptmt.setLong(2,accountNo);
                                    ptmt.execute();
                                    //get receiver's balance
                                    String q2="select * from users where accountNum=?";
                                    ptmt=con.prepareStatement(q2);
                                    ptmt.setLong(1,receiver);
                                    rs=ptmt.executeQuery();
                                    rs.next();
                                    long receiverBal=rs.getLong("balance");
                                    receiverBal+=amount;
                                    String q3="update users set balance=? where accountNum=?";
                                    ptmt=con.prepareStatement(q3);
                                    ptmt.setLong(1,receiverBal);
                                    ptmt.setLong(2,receiver);
                                    ptmt.execute();
                                    //after making transaction insert 2 tuples into transactions table
                                    //get previous transaction id
                                    Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                    sql="select * from transactions";
                                    rs=st.executeQuery(sql);
                                    //resultant table has all tuples
                                    //rs.last() return false if table is empty
                                    //else it moves cursor to last row and returns true
                                    long lastTId=1;//lastTId will not get updated if transactions table is empty
                                    if(rs.last()){
                                        //now cursor is at last row fetch transactionId from that tuple
                                        lastTId=rs.getLong("transactionid");
                                    }
                                    //insert into transactions table
                                    //credit transaction
                                    //debit transaction

                                    String qry="insert into transactions (transactionId,senderAccount,receiverAccount,amount,dateOfTransaction) values (?,?,?,?,?)";
                                    PreparedStatement pstmt=con.prepareStatement(qry);
                                    //set values of for  transaction(from sender to receiver)
                                    pstmt.setLong(1,lastTId);
                                    pstmt.setLong(2,accountNo);
                                    pstmt.setLong(3,receiver);
                                    pstmt.setLong(4,amount);
                                    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                                    //date has current date
                                    pstmt.setDate(5,date);
                                    pstmt.execute();
                                    System.out.println("transaction sucessfull");
                                }
                                catch(Exception e){
                                    con.rollback();
                                    System.out.println("unable to make transaction");
                                    e.printStackTrace();
                                    System.exit(0);
                                }
                                con.setAutoCommit(true);

                            }
                        }
                    }
                    else if(ch==3){
                        //balance enquiry
                        sql="select * from users where accountNum=?";
                        ptmt=con.prepareStatement(sql);
                        ptmt.setLong(1,accountNo);
                        rs=ptmt.executeQuery();
                        rs.next();
                        System.out.println("Available balance : "+rs.getLong("balance"));
                    }

                }
                con.close();

            } catch (SQLException e) {
                System.out.println("not able to connect with database....");
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
