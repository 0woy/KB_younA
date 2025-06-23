package org.scoula.sample.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.scoula.config.Rootconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringJUnitConfig(classes = {Rootconfig.class})
class SampleServiceImplTest {
    @Autowired
    private SampleService service;

    @Test
    void doAdd() throws Exception {
        log.info(service.doAdd("123","456"));
    }
}