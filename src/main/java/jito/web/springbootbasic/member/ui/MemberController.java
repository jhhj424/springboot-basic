package jito.web.springbootbasic.member.ui;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jito.web.springbootbasic.member.application.MemberService;
import jito.web.springbootbasic.member.dto.MemberRequest;
import jito.web.springbootbasic.member.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Api(tags = {"1. Member"})
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @ApiOperation(value = "회원 생성", notes = "회원을 생성한다.")
    @PostMapping("/members")
    public ResponseEntity createMember(@ApiParam(value = "회원", required = true) @RequestBody MemberRequest request) {
        MemberResponse member = memberService.createMember(request);
        return ResponseEntity.created(URI.create("/members/" + member.getId())).build();
    }

    @ApiOperation(value = "회원 단건 조회", notes = "회원 한명을 조회한다.")
    @GetMapping("/members/{id}")
    public ResponseEntity findMember(@ApiParam(value = "회원 ID", required = true) @PathVariable Long id) {
        MemberResponse member = memberService.findMember(id);
        return ResponseEntity.ok().body(member);
    }

    @ApiOperation(value = "회원 업데이트", notes = "회원 정보를 업데이트 한다.")
    @PutMapping("/members/{id}")
    public ResponseEntity updateMember(@ApiParam(value = "회원 ID", required = true) @PathVariable Long id,
                                       @ApiParam(value = "변경 할 회원 정보", required = true) @RequestBody MemberRequest request){
        memberService.updateMember(id, request);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "회원 삭제", notes = "회원 정보를 삭제한다.")
    @DeleteMapping("/members/{id}")
    public ResponseEntity deleteMember(@ApiParam(value = "회원 ID", required = true) @PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
