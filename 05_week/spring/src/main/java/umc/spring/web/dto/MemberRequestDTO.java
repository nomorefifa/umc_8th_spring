package umc.spring.web.dto;

import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto {
        private String name;
        private Integer gender;
//        private Integer birthYear;
//        private Integer birthMonth;
//        private Integer birthDay;
        private String email; // ✅ 추가
        private String address;
        private String specAddress;
        List<Long> preferCategory;
    }
}
