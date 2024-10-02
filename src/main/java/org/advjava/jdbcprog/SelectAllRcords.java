package org.advjava.jdbcprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllRcords {
    private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb";

    private static final String DB_uname="root";

    private static final String DB_pwd="Admin123";

    private static final String SELECT_SQL="SELECT * FROM BOOKS";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(DB_URL,DB_uname,DB_pwd);
        Statement statement=con.createStatement();
        ResultSet resultSet=statement.executeQuery(SELECT_SQL);
        while(resultSet.next()){
            System.out.println(resultSet.getInt("BOOK_ID")+" "+resultSet.getString("BOOK_NAME")+" "+resultSet.getDouble("BOOK_PRICE"));
        }
    }
}
