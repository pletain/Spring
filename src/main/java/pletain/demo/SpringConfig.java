package pletain.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pletain.demo.repository.MemberRepository;
import pletain.demo.repository.MemoryMemberRepository;
import pletain.demo.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}