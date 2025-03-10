package com.gdg.rolling.respository;

import com.gdg.rolling.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findAllByPaper_Id(Long paperId);
    Optional<Member> findByPaper_IdAndId(Long paperId, Long memberId);
}
