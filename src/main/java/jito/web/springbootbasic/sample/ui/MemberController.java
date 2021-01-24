package jito.web.springbootbasic.sample.ui;

import jito.web.springbootbasic.sample.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @GetMapping("sample")
    public ResponseEntity<Member> sampleFindMember() {
        Member member = new Member(1L, "테스트 사용자");
        return ResponseEntity.ok().body(member);
    }
}
