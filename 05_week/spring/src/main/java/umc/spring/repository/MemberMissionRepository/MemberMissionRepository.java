package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    List<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus status);
    Page<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
}