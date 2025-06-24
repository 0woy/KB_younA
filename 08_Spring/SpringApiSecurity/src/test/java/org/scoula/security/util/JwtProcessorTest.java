package org.scoula.security.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.Rootconfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Rootconfig.class, SecurityConfig.class})
@Log4j2
class JwtProcessorTest {

    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {
        String username = "user0";
        String token = jwtProcessor.generateToken(username);
        log.info(token);

        assertNotNull(token);
    }

    @Test
    void getUsername() {
        String token="eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDc0Mjk0MiwiZXhwIjoxNzUwNzQzMjQyfQ.ATLTSyIt7ZES9ydrJ7Ssf_NaMCn6FTqcf9-tUCQeHz8_yCyC9umdUfZnOr_X8ac4";

        String username = jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username);
    }

    @Test
    void validateToken() {
        String token="eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDc0Mjk0MiwiZXhwIjoxNzUwNzQzMjQyfQ.ATLTSyIt7ZES9ydrJ7Ssf_NaMCn6FTqcf9-tUCQeHz8_yCyC9umdUfZnOr_X8ac4";

        boolean isValid = jwtProcessor.validateToken(token);
        log.info(isValid);
        assertTrue(isValid);
    }
}