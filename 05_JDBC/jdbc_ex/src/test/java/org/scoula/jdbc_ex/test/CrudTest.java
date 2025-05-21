package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.Common.JDBCUtil;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void closeConnection() {
        JDBCUtil.close();
    }
    @Test
    @DisplayName("새로운 USER 등록")
    // catch를 사용하면, JUNIT은 성공으로 간주하므로 테스트 실패를 확인할 수 없음
    public void insertUser() throws SQLException {
        String sql = "insert into users (id, password, name, role) values(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1, "catch");
        pstmt.setString(2, "scoula3");
        pstmt.setString(3, "스콜라");
        pstmt.setString(4, "USER");

        int count = pstmt.executeUpdate();
        Assertions.assertEquals(1, count);
        }

    }

    @Test
    @DisplayName("user 목록을 추출한다.")
    public void selectUser() throws SQLException {
        String sql ="select * from users";
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()) {
                System.out.println(
                        rs.getString("id")+" "+
                        rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("특정 user 검색한다.")
    public void selectUserById() throws SQLException {
        String userID ="scoula";
        String sql ="select * from users where id=?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userID);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()) {
                    System.out.println(rs.getString("name"));
                }else{
                    throw new SQLException();
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user 수정한다.")
    public void updateUser() throws SQLException {
        String userID ="catch";
        String sql = "update users set name=? where id=?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, "캐치");
            pstmt.setString(2, userID);
            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("특정 User 삭제")
    public void deleteUser() throws SQLException {
        String userId = "scoula";
        String sql = "delete from users where id=?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userId);
            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

}
