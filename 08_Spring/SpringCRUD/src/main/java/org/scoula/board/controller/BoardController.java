package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    public void create() {
        log.info("create");
    }

    @PostMapping("/create")
    public String create(BoardDTO board) {
        log.info("DTO.title = {}", board.getTitle());
        log.info("DTO.content = {}", board.getContent());
        log.info("DTO.writer = {}", board.getWriter());
        try {
            service.create(board);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/update"})
    public void getOne(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");

        model.addAttribute("board", service.getOne(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update: " + board);

        service.update(board);

        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no, RedirectAttributes ra) {
        log.info("delete: " + no);
        if (service.delete(no)) {
            ra.addAttribute("result", "success");
        }
        return "redirect:/board/list";
    }
    @GetMapping("/download/{no}")
    @ResponseBody // view를 사용하지 않고, 직접 내보냄
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attach = service.getAttachment(no);
        File file = new File(attach.getPath());
        UploadFiles.download(response, file, attach.getFilename());
    }


}


