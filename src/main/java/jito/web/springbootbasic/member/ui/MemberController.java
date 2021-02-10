package jito.web.springbootbasic.member.ui;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jito.web.springbootbasic.member.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. Member"})
@RestController
@RequestMapping("/members")
public class MemberController {

    @ApiOperation(value = "샘플", notes = "테스트용 api")
    @GetMapping("/sample")
    public ResponseEntity<Member> sampleFindMember() {
        Member member = new Member("jhhj424@naver.com", "지토");
        return ResponseEntity.ok().body(member);
    }
}
