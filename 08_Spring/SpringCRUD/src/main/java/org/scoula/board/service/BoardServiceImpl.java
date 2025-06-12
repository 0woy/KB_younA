package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final private BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        log.info("getList...............");
        return boardMapper.getList().stream()
                .map(BoardDTO::of)
                .toList();
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get.................." + no);
        BoardDTO boardDTO = BoardDTO.of(boardMapper.get(no));

        return Optional.ofNullable(boardDTO).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void create(BoardDTO board) {
        log.info("create......." + board);

        BoardVO vo = board.toVO();
        boardMapper.create(vo);
        board.setNo(vo.getNo());
    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update........" + board);
        return boardMapper.update(board.toVO())==1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete..............." + no);
        return boardMapper.delete(no)==1;
    }
}
