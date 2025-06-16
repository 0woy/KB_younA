package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService service;

    @GetMapping("/list")
    void list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    void create() {
        log.info("create");
    }

    @PostMapping("/create")
    String create(BoardDTO board) {
        log.info("create: "+board);
        service.create(board);
        return "redirect:/board/list";
    }

    @GetMapping({"/get","/update"})
    void get(@RequestParam("no") Long no, Model model){
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/update")
    String update(BoardDTO board, RedirectAttributes ra) {
        if(service.update(board)){
            ra.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    String delete(@RequestParam("no") Long no, RedirectAttributes ra) {
        if(service.delete(no)){
            ra.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

}
