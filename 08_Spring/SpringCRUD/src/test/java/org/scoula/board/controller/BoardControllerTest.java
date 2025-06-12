package org.scoula.board.controller;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.service.BoardService;
import org.scoula.config.Rootconfig;
import org.scoula.config.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ServletConfig.class, Rootconfig.class})
@WebAppConfiguration
@Log4j2
@Transactional
class BoardControllerTest {

    @Autowired
    BoardService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }

    @Test
    @DisplayName("GET- list()")
    void list() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap();
        log.info(model);
    }

    @Test
    @DisplayName("GET - Create()")
    void create() throws Exception {
        String viewName = mockMvc.perform(MockMvcRequestBuilders.get("/board/create"))
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(viewName);
    }

    @Test
    @DisplayName("POST - Create()")
    void postCreate() throws Exception {
        String resPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/create")
                        .param("title", "테스트 새 글 제목")
                        .param("content", "테스트 새 글 내용")
                        .param("writer", "user1"))
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resPage);
    }

    @Test
    @DisplayName("GET -get()")
    void get() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
                        .param("no", "2"))
                .andReturn()
                .getModelAndView()
                .getModelMap();

        log.info(model);
    }

    @Test
    @DisplayName("POST - update()")
    void update() throws Exception {
        String viewName = mockMvc.perform(MockMvcRequestBuilders.post("/board/update")
                        .param("no", "1")
                        .param("title", "수정된 새 글 제목")
                        .param("content", "수정된 새 글 내용")
                        .param("writer", "user00"))
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(viewName);
    }

    @Test
    @DisplayName("POST - delete()")
    void delete() throws Exception {
        String viewName = mockMvc.perform(MockMvcRequestBuilders.post("/board/delete")
                        .param("no", "2"))
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(viewName);
    }

}