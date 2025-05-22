package umc.spring.converter;

import org.springframework.data.domain.Page;
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

    public static ReviewResponseDTO.ReviewPreviewDTO toPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .reviewId(review.getId())
                .content(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO toPreviewListDTO(Page<Review> reviewPage) {
        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .reviewList(reviewPage.getContent().stream()
                        .map(ReviewConverter::toPreviewDTO)
                        .toList())
                .listSize(reviewPage.getSize())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}
