package pletain.demo.service;

import org.junit.jupiter.api.Test;

import pletain.demo.domain.Member;

import static org.assertj.core.api.Assertions.*;
public class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("user1");

        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}