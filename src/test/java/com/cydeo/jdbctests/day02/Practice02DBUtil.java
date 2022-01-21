package com.cydeo.jdbctests.day02;

import com.cydeo.jdbctests.utility.DB_Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class Practice02DBUtil {

    @Test
    public void test1(){
        //create connection
        DB_Util.createConnection();

        //run query
        DB_Util.runQuery("select FIRST_NAME,LAST_NAME,SALARY,JOB_ID from employees");

        //get all data as list of map
        List<Map<String, String>> allRowAsListOfMap = DB_Util.getAllRowAsListOfMap();

        //print each row into screen
        for(Map<String ,String >eachRow: allRowAsListOfMap){
            System.out.println(eachRow);
        }

    }
}
