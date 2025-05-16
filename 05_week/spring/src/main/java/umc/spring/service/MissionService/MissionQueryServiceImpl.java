package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResponseDTO.MissionListDTO getMissionList(Long memberId, MissionStatus status) {
        List<MemberMission> missions = memberMissionRepository.findByMemberIdAndStatus(memberId, status);
        return MissionConverter.toListDTO(missions);
    }
}
