package pletain.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pletain.demo.domain.Member;
import pletain.demo.repository.MemoryMemberRepository;
public class MemberServiceTest {

    //Dependency Injection(DI), 클래스 내부가 아닌 외부에서 주입
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach // 각 동작 이전에
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    MemoryMemberRepository MemberRepository = new MemoryMemberRepository();

    //DB에 저장되는 값들 지워주기
    @AfterEach //동작한 후에
    public void afterEach() {
        MemberRepository.clearStore();
    }

    @Test
    void join() {
        //given,어떤 데이터가 들어오는지(기반)
        Member member = new Member();
        member.setName("user1");

        //when, 무엇을 검증하는지
        Long saveId = memberService.join(member);

        //then, 검증구간
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    @Test 
    public void 중복회원예외() {

        //given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        // memberService.join(member1);
        // try {
        //     memberService.join(member2);
        //     fail();
        // } catch (IllegalStateException e) {
        //     // 에러메세지가 "이미 존재하는 회원임!"와 같다고 주장
        //     assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원임!"); 
        // }

         //try catch문을 사용하지 않고 테스트 하기
        memberService.join(member1);
         //오른쪽 로직을 실행할 때, 왼쪽 예외가 터질 것이다라고 주장
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        
    }


    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}