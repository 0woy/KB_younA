package org.scoula.board.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.pagination.Page;
import org.scoula.common.pagination.PageRequest;
import org.scoula.common.util.UploadFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Log4j2
@Api(tags = "게시글 관리")
public class BoardController {
    private final BoardService service;

    @GetMapping("")
    public ResponseEntity<Page> getList(PageRequest pageRequest) {
        return ResponseEntity.ok(service.getPage(pageRequest));
    }

//    @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
//            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
//            @ApiResponse(code = 500, message = "서버에 오류가 발생했습니다.")
//    })
//
//    @GetMapping("")
//    public ResponseEntity<List<BoardDTO>> getList() {
//        return ResponseEntity.ok(service.getList());
//    }

    @ApiOperation(value = "상세 정보 얻기", notes = "게시글 상세 정보를 얻는 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에 오류가 발생했습니다.")
    })
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> getList(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

    @ApiOperation(value = "게시글 생성", notes = "게시글 생성 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에 오류가 발생했습니다.")
    })
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(
            @ApiParam(value = "게시글 객체", required = true)
            BoardDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @ApiOperation(value = "게시글 수정", notes = "게시글 수정 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에 오류가 발생했습니다.")
    })
    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no,
            @ApiParam(value = "게시글 객체", required = true)
            BoardDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다."),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에 오류가 발생했습니다.")
    })
    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no) {
        return ResponseEntity.ok(service.delete(no));
    }


    @GetMapping("/download/{no}")
    public void download(@PathVariable Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attachment = service.getAttachment(no);
        File file = new File(attachment.getPath());
        UploadFiles.download(response, file, attachment.getFilename());
    }

    @DeleteMapping("/deleteAttachment/{no}")
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable Long no) throws Exception {
        return ResponseEntity.ok(service.deleteAttachment(no));
    }

}
