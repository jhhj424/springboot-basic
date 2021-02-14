package jito.web.springbootbasic.member.dto;

import jito.web.springbootbasic.member.domain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequest {
    private String email;
    private String password;
    private Integer age;

    public Member toMember() {
        return new Member(email, password, age);
    }
}