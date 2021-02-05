package jito.web.springbootbasic.member.ui;

import jito.web.springbootbasic.member.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    @GetMapping("/sample")
    public ResponseEntity<Member> sampleFindMember() {
        Member member = new Member("테스트 사용자", 10);
        return ResponseEntity.ok().body(member);
    }
}
