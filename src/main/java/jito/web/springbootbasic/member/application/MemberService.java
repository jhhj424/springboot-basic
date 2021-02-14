package jito.web.springbootbasic.member.application;

import jito.web.springbootbasic.member.domain.Member;
import jito.web.springbootbasic.member.domain.MemberRepository;
import jito.web.springbootbasic.member.dto.MemberRequest;
import jito.web.springbootbasic.member.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponse createMember(MemberRequest request) {
        Member member = memberRepository.save(request.toMember());
        return MemberResponse.of(member);
    }

    public MemberResponse findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return MemberResponse.of(member);
    }

    public void updateMember(Long id, MemberRequest request) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        member.update(request.toMember());
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
