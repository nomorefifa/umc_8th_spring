package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.mapping.Mission;
import umc.spring.domain.mapping.Store;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final MissionCommandService missionCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDTO.CreateResultDTO> createStore(
            @RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {

        Store savedStore = storeCommandService.createStore(request);
        StoreResponseDTO.CreateResultDTO responseDTO = StoreConverter.toCreateResultDTO(savedStore);
        return ApiResponse.onSuccess(responseDTO);
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO dto) {

        Mission saved = missionCommandService.createMission(storeId, dto);
        MissionResponseDTO.CreateResultDTO response = MissionConverter.toCreateResultDTO(saved);

        return ApiResponse.onSuccess(response);
    }
}