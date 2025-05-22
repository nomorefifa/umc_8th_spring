package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.Mission;
import umc.spring.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }

    public static MemberMissionResponseDTO.OngoingMissionPreviewDTO toPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.OngoingMissionPreviewDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .build();
    }

    public static MemberMissionResponseDTO.OngoingMissionListDTO toListDTO(Page<MemberMission> missions) {
        return MemberMissionResponseDTO.OngoingMissionListDTO.builder()
                .missionList(missions.getContent().stream()
                        .map(MemberMissionConverter::toPreviewDTO)
                        .toList())
                .listSize(missions.getSize())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }
}
