package org.advjava.jdbcprog;


import org.omg.Messaging.SyncScopeHelper;

import java.sql.*;

public class SelectBooks {
    private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb";

    private static final String DB_uname="root";

    private static final String DB_pwd="Admin123";

    private static final String SELECT_SQL="SELECT * FROM BOOKS WHERE BOOK_ID=101";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(DB_URL,DB_uname,DB_pwd);
        Statement statement=con.createStatement();
        ResultSet resultSet=statement.executeQuery(SELECT_SQL);
        if(resultSet.next()){
            int bookid=resultSet.getInt("BOOK_ID");
            String name=resultSet.getString("BOOK_NAME");
            double price=resultSet.getDouble("BOOK_PRICE");
            System.out.println(bookid+" "+name+" "+price);
        }else{
            System.out.println("no records found");
        }

    }
}
