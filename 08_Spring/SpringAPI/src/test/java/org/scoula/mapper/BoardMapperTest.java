package org.scoula.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.config.Rootconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Rootconfig.class})
@Log4j2
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("BoardMapper의 목록 불러오기")
    void getList() {
        for(BoardVO v: boardMapper.getList()){
            log.info(v);
        }
    }

    @Test
    @DisplayName("단일 목록 불러오기")
    void get(){
        BoardVO v = boardMapper.get(1L);
        log.info(v);
    }
    
    @Test
    @DisplayName("단일 목록 추가하기")
    void create(){
//        boardMapper.create(BoardVO.builder()
//                .title("추가1")
//                .content("추가 내용1")
//                .writer("0woy")
//                .build());
        BoardVO board = new BoardVO();
        board.setTitle("아이디 null2");
        board.setContent("아이디가 null 값으로 주어질까");
        board.setWriter("help");

//        boardMapper.create(board);

        BoardVO res = boardMapper.get(8L);
        log.info(res);
        
    }
    
    @Test
    @DisplayName("update 하기")
    void update(){
        BoardVO board = new BoardVO();
        board.setNo(8L);
        board.setTitle("어 이거 수정할 거야");
        board.setContent("수정 후");
        board.setWriter("help");

        int count =boardMapper.update(board);
        log.info("Update count: "+count);

    }
    
    @Test
    @DisplayName("DELETE 하기")
    void delete(){
        int count = boardMapper.delete(10L);
        Assertions.assertEquals(1,count);
    }
}