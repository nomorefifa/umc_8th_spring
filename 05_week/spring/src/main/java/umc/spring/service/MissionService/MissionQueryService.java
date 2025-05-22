package umc.spring.service.MissionService;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionResponseDTO;

public interface MissionQueryService {
    MemberMissionResponseDTO.MissionListDTO getMissionList(Long memberId, MissionStatus status);
    MissionResponseDTO.MissionPreviewListDTO getMissionsByStore(Long storeId, int page);
}