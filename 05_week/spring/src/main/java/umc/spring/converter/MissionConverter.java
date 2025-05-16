package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponseDTO;

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
}