package pletain.demo.repository;

import pletain.demo.domain.Member;

import java.util.List;
import java.util.Optional;

//Repository 인터페이스

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}