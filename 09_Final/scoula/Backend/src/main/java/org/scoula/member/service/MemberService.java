package org.scoula.member.service;

import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.security.account.domain.MemberDTO;

public interface MemberService {
    boolean checkDuplicate(String username);

    MemberDTO get(String username);

    MemberDTO join(MemberJoinDTO member);
}
