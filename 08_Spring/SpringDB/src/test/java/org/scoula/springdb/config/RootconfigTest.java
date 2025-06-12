package org.scoula.springdb.config;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Rootconfig.class})
@Log4j2
class RootconfigTest {

    @Autowired
    private DataSource dataSource;
    
    @Test
    @DisplayName("DataSource 연결")
    void dataSource() throws SQLException {
        try (Connection conn = dataSource.getConnection()){
            log.info("DataSource 준비 완료");
            log.info(conn);
        }
    }
}