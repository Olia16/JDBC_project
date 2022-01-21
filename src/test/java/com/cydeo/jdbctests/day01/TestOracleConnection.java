package com.cydeo.jdbctests.day01;

import java.sql.*;

public class TestOracleConnection {

    public static void main(String[] args) throws SQLException {
        //what is connection string - includes URL - username-password
        //how to connect database? - connection, statements, resultSet

        String dbUrl = "jdbc:oracle:thin:@3.84.251.99:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        //DriverManager class getConnection method is used for make connection with DB
        Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        //create statement from Connection to run Queries
        Statement statement = conn.createStatement();

        //using with statement we will execute query
        ResultSet resultSet = statement.executeQuery("select * from regions");


        //move to cursor first
        resultSet.next();

        //now we are at first row, we will get data
       System.out.println("result: " + resultSet.getString("region_name"));
       System.out.println("result: " + resultSet.getString(2));
//
//       //second row
//        resultSet.next();
//        System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
//
//        //third row
//        resultSet.next();
//        System.out.println(resultSet.getInt("region_id") + "-" + resultSet.getString("region_name"));

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
        }

        //close connection
        resultSet.close();
        statement.close();
        conn.close();


    }
}
