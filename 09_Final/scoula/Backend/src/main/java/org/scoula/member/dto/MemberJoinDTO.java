package org.scoula.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberJoinDTO {
    MemberVO member;
    private String username;
    private String password;
    private String email;
    private MultipartFile avatar;

    public MemberVO toVO() {
        return MemberVO.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
