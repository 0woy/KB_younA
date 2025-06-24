package org.scoula.security.account.dto;

//규약에 따라 username, password 프로퍼티를 가짐
//RequestBody의 json 문자열에서 LoginDTO 객체로 역직렬화 직접 수행

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.http.HttpServletRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String username;
    private String password;

    public static LoginDTO of(HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(request.getInputStream(), LoginDTO.class);
        }catch (Exception e) {
            throw new BadCredentialsException("username 또는 password가 없음.");
        }
    }

}
