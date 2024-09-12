package org.advjava.jdbcprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCFirstProgram {
    private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb";

    private static final String DB_uname="root";

    private static final String DB_pwd="Admin123";

    private static final String INSERT_SQL="INSERT INTO BOOKS VALUE(101,'JAVA','2000')";

    public static void main(String[] args) throws Exception {

        //load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //get thd DB connection
        Connection con= DriverManager.getConnection(DB_URL,DB_uname,DB_pwd);

        //Create Statement
        Statement statement= con.createStatement();

        //Execute query
        int rowsEffected=statement.executeUpdate(INSERT_SQL);

        //Process Result
        System.out.println("Record Inserted count:"+rowsEffected);

        //Close the connection
        con.close();



    }
}
