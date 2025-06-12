package org.scoula.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.config.Rootconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Rootconfig.class})
@Log4j2
class BoardServiceImplTest {

    @Autowired
    private BoardService service;
    @Autowired
    private BoardMapper boardMapper;

    @Test
    void getList() {
        for (BoardDTO dto : service.getList()){
            log.info(dto);
        }
    }

    @Test
    void get() {
        log.info(service.get(1L));
        Assertions.assertNotNull(service.get(10L));
    }

    @Test
    void create() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("dto 새로운 게시글");
        boardDTO.setContent("dto 내용");
        boardDTO.setWriter("dto");

        service.create(boardDTO);
        log.info(boardDTO.getNo());
    }

    @Test
    void update() {
        BoardDTO boardDTO = service.get(11L);
        boardDTO.setTitle("제목 수정함");
        log.info(service.update(boardDTO));
    }

    @Test
    void delete() {
        log.info(service.delete(11L));
        for(BoardDTO v : service.getList()){
            log.info(v);
        }

    }
}