package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MissionRestController {

    private final MissionQueryService missionQueryService;

    @GetMapping("/{memberId}/missions")
    public ApiResponse<MemberMissionResponseDTO.MissionListDTO> getMissionsByStatus(
            @PathVariable Long memberId,
            @RequestParam("status") MissionStatus status) {
        return ApiResponse.onSuccess(
                missionQueryService.getMissionList(memberId, status)
        );
    }
}
