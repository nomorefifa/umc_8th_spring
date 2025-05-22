package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewResponseDTO;

public interface ReviewQueryService {
    ReviewResponseDTO.ReviewPreviewListDTO getMyReviews(Long memberId, int page);
}
