package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewDTO {
        private Long memberMissionId;
        private String missionSpec;
        private Integer reward;         // ← DB 컬럼명 기준 reward 사용
        private LocalDateTime deadline;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionListDTO {
        private List<MissionPreviewDTO> missionList;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeResultDTO {
        private Long memberMissionId;
        private Long missionId;
        private String status;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OngoingMissionPreviewDTO {
        private Long memberMissionId;
        private String missionSpec;
        private Integer reward;
        private LocalDateTime deadline;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OngoingMissionListDTO {
        private List<OngoingMissionPreviewDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
