package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MemberMissionResponseDTO.ChallengeResultDTO> challengeMission(@PathVariable Long missionId) {
        MemberMission saved = memberMissionCommandService.challengeMission(missionId);
        MemberMissionResponseDTO.ChallengeResultDTO response = MemberMissionConverter.toChallengeResultDTO(saved);
        return ApiResponse.onSuccess(response);
    }

    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/{userId}")
    public ApiResponse<MemberMissionResponseDTO.OngoingMissionListDTO> getMyMissions(
            @PathVariable Long userId,
            @RequestParam MissionStatus status,
            @RequestParam(defaultValue = "0") int page) {

        return ApiResponse.onSuccess(
                memberMissionQueryService.getMyMissionListByStatus(userId, status, page)
        );
    }
}