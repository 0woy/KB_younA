package org.scoula.security.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    private String username;
    private String email;
    private Date regDate;
    private Date updateDate;

    private MultipartFile avatar;

    private List<String> authList;  // 권한 목록, JOIN 처리

    public static MemberDTO of(MemberVO vo) {
        return MemberDTO.builder()
                .username(vo.getUsername())
                .email(vo.getEmail())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .authList(vo.getAuthList().stream().map(auth -> auth.getAuth()).toList())
                .build();
    }

    public MemberVO toVO() {
        return MemberVO.builder()
                .username(username)
                .email(email)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}
