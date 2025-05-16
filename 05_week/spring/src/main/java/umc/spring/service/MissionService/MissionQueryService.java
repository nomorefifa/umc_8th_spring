package umc.spring.service.MissionService;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MemberMissionResponseDTO;

public interface MissionQueryService {
    MemberMissionResponseDTO.MissionListDTO getMissionList(Long memberId, MissionStatus status);
}