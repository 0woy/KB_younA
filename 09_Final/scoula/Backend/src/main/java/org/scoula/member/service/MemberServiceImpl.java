package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberDTO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional // join
public class MemberServiceImpl implements MemberService {
    final PasswordEncoder passwordEncoder;
    final MemberMapper memberMapper;

    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = memberMapper.findByUsername(username);
        return member != null;
    }

    @Override
    public MemberDTO get(String username) {
        MemberVO member = Optional.ofNullable(memberMapper.get(username))
                .orElseThrow(NoSuchElementException::new);

        return MemberDTO.of(member);
    }

    private void saveAvatar(MultipartFile avatar, String username) {
        // avatar upload
        if (avatar != null && avatar.isEmpty()) {
            File dest = new File("c:/upload/avatar/", username + ".png");
            try {
                avatar.transferTo(dest);
            } catch (IOException e) {
                // why Runtime?
                // 1. Transactional : runtimeException에만 Transactional 반은
                // 2.
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public MemberDTO join(MemberJoinDTO joinDTO) {
        MemberVO memberVO = joinDTO.toVO();

        // 비밀번호 암호화
        memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
        memberMapper.insert(memberVO);

        AuthVO auth = new AuthVO();
        auth.setUsername(memberVO.getUsername());
        auth.setAuth("ROLE_MEMBER");
        memberMapper.insertAuth(auth);

        saveAvatar(joinDTO.getAvatar(), memberVO.getUsername());

        return get(memberVO.getUsername());
    }
}
