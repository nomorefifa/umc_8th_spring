package umc.spring.service.ReviewService;

import umc.spring.domain.mapping.Review;

import java.util.List;

public interface ReviewQueryService {
    List<Review> getReviewsByStoreId(Long storeId);
}
