package jito.web.springbootbasic.sample.domain;

import jito.web.springbootbasic.member.domain.Member;
import jito.web.springbootbasic.member.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {
    private Member member;

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager entityManager;

    @BeforeEach
    void setUp() {
        member = new Member("jhhj424@naver.com", "지토");
    }

    @Test
    @DisplayName("멤버 저장")
    public void create() {
        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember).isEqualTo(member);
        assertThat(savedMember.getId()).isEqualTo(member.getId());
        assertThat(savedMember.getName()).isEqualTo(member.getName());
        assertThat(savedMember.getEmail()).isEqualTo(member.getEmail());
    }

    @Test
    @DisplayName("멤버 조회")
    public void findById() {
        // given
        memberRepository.save(member);
        entityManager.clear();

        // when
        Member findMember = memberRepository.findById(member.getId()).get();

        // then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
    }

    @Test
    @DisplayName("멤버 삭제")
    public void delete() {
        memberRepository.save(member);

        // when
        memberRepository.delete(member);

        // then
        List<Member> findAllMembers = memberRepository.findAll();
        assertThat(findAllMembers).isEmpty();
    }
}
