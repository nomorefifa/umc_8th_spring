package umc.spring.service.ReviewService;

import umc.spring.domain.mapping.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(Long storeId, ReviewRequestDTO.CreateReviewDTO dto);
}