package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.Common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("jdbc_ex db에 접속한다.")
    public void testConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_ex";
        String id = "scoula";
        String pw = "1234";

        Connection con = DriverManager.getConnection(url, id, pw);
        System.out.println("DB 연결 성공");
        con.close();
    }
    
    @Test
    @DisplayName("jdbc_ex에 접속, 자동 닫기")
    public void testConnection2() throws SQLException{
        try(Connection conn = JDBCUtil.getConnection()){
            System.out.println("DB 연결 성공");
        }
    }
}
