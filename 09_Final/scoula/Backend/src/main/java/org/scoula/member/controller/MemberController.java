package org.scoula.member.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.common.util.UploadFiles;
import org.scoula.member.dto.ChangePasswrodDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.service.MemberService;
import org.scoula.security.account.domain.MemberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    final MemberService memberService;

    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(memberService.checkDuplicate(username));
    }

    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username, HttpServletResponse response) {
        String avatarPath = "c:/upload/avatar/" + username + ".png";
        File file = new File(avatarPath);
        if (!file.exists()) {
            file = new File("c:/upload/avatar/unknown.png");
        }
        UploadFiles.downloadImage(response, file);
    }

    @PostMapping("")
    public ResponseEntity<MemberDTO> join(MemberJoinDTO memberJoinDTO) {
        return ResponseEntity.ok(memberService.join(memberJoinDTO));
    }

    @PutMapping("/{username}")
    public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) {
        return ResponseEntity.ok(memberService.update(member));
    }


    // multipart가 없으므로 application/json 인코딩 처리 = RequestBody 설정 必
    @PutMapping("/{username}/changepassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswrodDTO changePasswrod) {
        memberService.changePassword(changePasswrod);
        return ResponseEntity.ok().build();
    }

}
