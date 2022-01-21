package com.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Practice01_JDBC_Intro {

    String dbUrl = "jdbc:oracle:thin:@3.84.251.99:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {
        //DriverManager class getConnection method is used for make connection with DB
        Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        //create statement from Connection to run Queries
        Statement statement = conn.createStatement();

        //using with statement we will execute query
        ResultSet resultSet = statement.executeQuery("select * from departments where manager_id is not null");

        //10 - Administration - 200 -1700

            while (resultSet.next()){   //boolean condition, to loop through the whole table
            System.out.println(resultSet.getInt(1) //gets first column, using index
             +"-"+resultSet.getString("department_name") + "-"  // gets second column using name of the column
             + resultSet.getInt(3) + "-" + resultSet.getInt(4));  // gets third and fourth columns
        }
            //
        resultSet = statement.executeQuery("select * from regions");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString("region_name"));
            }

        //close connection
        resultSet.close();
        statement.close();
        conn.close();


    }
}
