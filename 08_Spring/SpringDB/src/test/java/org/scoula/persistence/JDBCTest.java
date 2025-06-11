package org.scoula.persistence;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j2
public class JDBCTest {

    @BeforeAll
    static void setup(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    @DisplayName("JDBC 드라이버 연동")
    public void setupConnection(){
        String url = "jdbc:mysql://localhost:3306/scoula_db";
        try(Connection conn = DriverManager.getConnection(url, "scoula", "1234")) {
            log.info(conn);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
}
