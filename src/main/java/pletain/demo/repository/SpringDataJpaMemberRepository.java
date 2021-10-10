package pletain.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pletain.demo.domain.Member;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
    
}