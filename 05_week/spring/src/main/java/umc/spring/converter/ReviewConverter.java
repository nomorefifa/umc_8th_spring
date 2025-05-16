package umc.spring.converter;

import umc.spring.domain.mapping.Member;
import umc.spring.domain.mapping.Review;
import umc.spring.domain.mapping.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewDTO dto, Member member, Store store) {
        return Review.builder()
                .score(dto.getScore())
                .body(dto.getBody())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .score(review.getScore())
                .body(review.getBody())
                .build();
    }
}
