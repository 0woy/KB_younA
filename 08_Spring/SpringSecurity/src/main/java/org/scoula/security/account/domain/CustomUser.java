package org.scoula.security.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class CustomUser extends User {

    private MemberVO member;

    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password,authorities);
    }
    public CustomUser(MemberVO member) {
        super(member.getUsername(), member.getPassword(), member.getAuthList());
        this.member = member;
    }
}
