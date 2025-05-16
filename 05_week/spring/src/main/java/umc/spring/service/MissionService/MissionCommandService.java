package umc.spring.service.MissionService;

import umc.spring.domain.mapping.Mission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO request);
}