/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.*;
/**
 *
 * @author Thuy Linh
 */
public class JBDCUtilts {
    private static Connection conn ;
    public static Connection getConnection(){
        if(conn == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url ="jdbc:sqlserver://localhost:1433;databasename=QLDIEM";
                conn=DriverManager.getConnection(url,"sa","sa");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
}
