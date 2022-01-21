package com.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Practice02_FlexibleNavigation {

    String dbUrl = "jdbc:oracle:thin:@3.84.251.99:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {
        //DriverManager class getConnection method is used for make connection with DB
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        //create statement from Connection to run Queries
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //using with statement we will execute query
        ResultSet resultSet = statement.executeQuery("select first_name,last_name from employees");


        //first row
        resultSet.next();
        System.out.println(resultSet.getString(1) + "-" + resultSet.getString(2));

        //second row
        resultSet.next();
        System.out.println(resultSet.getString(1) + "-" + resultSet.getString(2));

        //last row
        resultSet.last();
        System.out.println(resultSet.getString(1)+"-" + resultSet.getString(2));


        //returns your position, current row ; if we need to know the sum of rows, we jump to last and then use getRow method
        System.out.println( resultSet.getRow());

        //jump to row 8
        resultSet.absolute(8);
        System.out.println(resultSet.getString(1)+"-" + resultSet.getString(2));

        //go to previous row
        resultSet.previous();
        System.out.println(resultSet.getRow());
        System.out.println(resultSet.getString(1)+"-" + resultSet.getString(2));


        //last
        resultSet.last();
        System.out.println(resultSet.getRow());
        System.out.println(resultSet.getString(1)+"-" + resultSet.getString(2));


        //before first - moves to before first row - the begging of the table
        resultSet.beforeFirst();

        //print all the data
        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+"-" + resultSet.getString(2));
        }

        //jump to the first row
        resultSet.first();
        System.out.println(resultSet.getRow());
        //close conn
        resultSet.close();
        statement.close();
        conn.close();



    }
}
