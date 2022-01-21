package com.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Practice03_MetadataTest {

    String dbUrl = "jdbc:oracle:thin:@3.84.251.99:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {
        //DriverManager class getConnection method is used for make connection with DB
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        //create statement from Connection to run Queries
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //using with statement we will execute query
        ResultSet resultSet = statement.executeQuery("select * from REGIONS");

        //DATAbase Metadata =>  info about database

        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println(dbMetaData.getUserName());
        System.out.println(dbMetaData.getDatabaseProductName());
        System.out.println(dbMetaData.getDatabaseProductVersion());
        System.out.println(dbMetaData.getDriverName());
        System.out.println(dbMetaData.getDriverVersion());

        ResultSetMetaData rsmd = resultSet.getMetaData();

        //how many column we have
        int columnCount = rsmd.getColumnCount();
        System.out.println(columnCount);

        //how can we learn columnName for second column

        System.out.println(rsmd.getColumnName(2));

        //print all column name dynamically
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsmd.getColumnName(i));
        }


        /*
        ResultSet:
        rs.next() -> to iterate each row
        rs.getString(index) -> to get data from related column


        ResultMetaData:
        rsmd.getColumnCount() -> to get column count
        rsmd.getColumnName(index) -> to get column info/name
         */

        while (resultSet.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(rsmd.getColumnName(i) + "-" + resultSet.getString(i));
            }
        }

        //close conn
        resultSet.close();
        statement.close();
        conn.close();

    }
}
