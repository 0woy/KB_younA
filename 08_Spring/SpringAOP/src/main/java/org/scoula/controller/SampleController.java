package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    @RequestMapping("")
    public void basic() {
        log.info("basic................");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) { //di 요청
        log.info(""+dto);
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name,
                       @RequestParam("age") int age) {
        log.info("name: "+name);
        log.info("age: "+age);

        return "ex02";
    }

    @GetMapping("/ex04")    // dto는 자동으로 전달, 그 외 타입은 전달x
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: "+dto);
        log.info("page: "+page);

        return "sample/ex04";
    }

    @GetMapping("/ex06")    // 리다이렉트 시 정보 전달
    public String ex06(RedirectAttributes ra) {
        log.info("ex06.............");

        ra.addAttribute("name", "AA");
        ra.addAttribute("age", 10);

        return "redirect:/sample/ex06-2";
    }

    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07() {
        log.info("ex07..............");

        SampleDTO dto = new SampleDTO();
        dto.setName("AA");
        dto.setAge(10);

        return dto;
    }


}
