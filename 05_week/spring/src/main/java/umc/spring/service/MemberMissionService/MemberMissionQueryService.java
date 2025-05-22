package umc.spring.service.MemberMissionService;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MemberMissionResponseDTO;

public interface MemberMissionQueryService {
    MemberMissionResponseDTO.OngoingMissionListDTO getMyMissionListByStatus(Long memberId, MissionStatus status, int page);
}
