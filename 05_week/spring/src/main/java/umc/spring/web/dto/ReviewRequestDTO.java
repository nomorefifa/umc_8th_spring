package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class CreateReviewDTO {
        private Float score;
        private String body;
    }
}
