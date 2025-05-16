package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.Mission;
import umc.spring.domain.mapping.Store;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MemberMissionResponseDTO.MissionPreviewDTO toPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MissionPreviewDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .build();
    }

    public static MemberMissionResponseDTO.MissionListDTO toListDTO(List<MemberMission> missions) {
        return MemberMissionResponseDTO.MissionListDTO.builder()
                .missionList(missions.stream()
                        .map(MissionConverter::toPreviewDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDTO dto, Store store) {
        return Mission.builder()
                .missionSpec(dto.getMissionSpec())
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.CreateResultDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }
}