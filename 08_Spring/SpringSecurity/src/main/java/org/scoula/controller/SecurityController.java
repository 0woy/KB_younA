package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@Log4j2
@RequestMapping("/security")
public class SecurityController {
    @GetMapping("/all") // 모두 접근 가능
    public void doAll() {
        log.info("do all can access everybody");
    }

//    @GetMapping("/member") // MEMBER 또는 ADMIN 권한 필요
//    public void doMember(Principal principal) {
//        log.info("username = "+principal.getName());
//    }

    @GetMapping("/member") // MEMBER 또는 ADMIN 권한 필요
    public void doMember(Authentication authentication) {
         UserDetails userDetails = (UserDetails) authentication.getPrincipal();
         log.info("username = "+userDetails.getUsername());
    }

    @GetMapping("/login")
    public void login() {
        log.info("login page");
    }

    @GetMapping("/admin") // ADMIN 권한 필요
    public void doAdmin(@AuthenticationPrincipal CustomUser user) {
        MemberVO member = user.getMember();
        log.info("member = "+member);
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }


}
