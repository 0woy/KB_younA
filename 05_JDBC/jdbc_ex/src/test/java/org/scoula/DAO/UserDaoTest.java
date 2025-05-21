package org.scoula.DAO;

import org.junit.jupiter.api.*;
import org.scoula.Common.JDBCUtil;
import org.scoula.Domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @AfterAll
    static void close(){
        JDBCUtil.close();
    }

    @Test
    @DisplayName("USER 등록")
    @Order(1)
    void create() throws SQLException {
        UserVO user = new UserVO("test1", "테스트 1", "admin123", "ADMIN");
        int count = userDao.create(user);
        assertEquals(1, count);
    }

    @Test
    @DisplayName("User DAO 전체 목록 추출")
    void findAll() throws SQLException {
        List<UserVO> list = userDao.findAll();
        for(UserVO user : list){
            System.out.println(user.toString());
        }
    }

    @Test
    @DisplayName("특정 user 1건 추출")
    void get() throws SQLException {
        String id = "catch";
        UserVO user = userDao.get(id).orElseThrow(NoSuchElementException::new);
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("특정 user 수정")
    void update() throws SQLException {
        String id = "catch";
        UserVO userVO = userDao.get(id).orElseThrow(() ->new NoSuchElementException("사용자를 찾을 수 없음"));
        String name ="수정 후 이름";
        String role = "MEMBER";
        userVO.setName(name);
        userVO.setRole(role);
        int count = userDao.update(userVO);
        Assertions.assertEquals(1, count);
    }

    @Test
    void delete() throws SQLException {
        String id = "catch";
        int delete = userDao.delete(id);
        Assertions.assertEquals(1, delete);
    }
}