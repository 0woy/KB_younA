package org.scoula.DAO;

import org.scoula.Common.JDBCUtil;
import org.scoula.Domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    Connection conn = JDBCUtil.getConnection();

    private String USER_LIST = "select * from users";
    private String USER_GET = "select * from users where id = ?";
    private String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
    private String USER_UPDATE = "UPDATE users SET name =?, role=? WHERE id =?";
    private String USER_DELETE = "DELETE FROM users WHERE id =?";

    private UserVO map(ResultSet rs) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getString("role"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    @Override
    public int create(UserVO user) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement(USER_INSERT)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getRole());

            return pstmt.executeUpdate();
        }
    }

    @Override
    public List<UserVO> findAll() throws SQLException {
        List<UserVO> userList = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(USER_LIST)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                UserVO user = map(rs);
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public Optional<UserVO> get(String id) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement(USER_GET)) {
            pstmt.setString(1, id);
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public int update(UserVO user) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement(USER_UPDATE)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getRole());
            pstmt.setString(3, user.getId());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement(USER_DELETE)) {
            pstmt.setString(1, id);
            return pstmt.executeUpdate();
        }
    }
}
