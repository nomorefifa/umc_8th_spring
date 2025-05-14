package umc.spring.repository.ReviewRepository;

import umc.spring.domain.mapping.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findAllByStoreId(Long storeId);
}
