package jito.web.springbootbasic.sample.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("멤버 저장")
    public void create() throws Exception {
        // given
        Member member = new Member("멤버a", 10);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember).isEqualTo(member);
        assertThat(savedMember.getId()).isEqualTo(member.getId());
        assertThat(savedMember.getName()).isEqualTo(member.getName());
        assertThat(savedMember.getAge()).isEqualTo(member.getAge());
    }

    @Test
    @DisplayName("멤버 조회")
    public void findById() throws Exception {
        // given
        Member member = new Member("멤버a", 10);
        memberRepository.save(member);

        // when
        Member findMember = memberRepository.findById(member.getId()).get();

        // then
        assertThat(findMember).isEqualTo(member);
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember.getAge()).isEqualTo(member.getAge());
    }

    @Test
    @DisplayName("멤버 삭제")
    public void delete() throws Exception {
        // given
        Member member = new Member("멤버a", 10);
        memberRepository.save(member);

        // when
        memberRepository.delete(member);

        // then
        List<Member> findAllMembers = memberRepository.findAll();
        assertThat(findAllMembers).isEmpty();
    }
}
