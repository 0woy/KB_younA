package org.scoula.Common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    static Connection conn = null;
    static{
        try {
            Properties prop = new Properties();
            prop.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String id = prop.getProperty("id");
            String password = prop.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return conn;
    }
    public static void close(){
        try {
            if(conn != null){
                conn.close();
                conn=null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
