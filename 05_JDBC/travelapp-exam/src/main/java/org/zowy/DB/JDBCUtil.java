package org.zowy.DB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static Connection conn =null;
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void close(){
        try {
            if(conn != null){
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
