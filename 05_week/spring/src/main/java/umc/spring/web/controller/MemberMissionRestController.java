package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
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
}