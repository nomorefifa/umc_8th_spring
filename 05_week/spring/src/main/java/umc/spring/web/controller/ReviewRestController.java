package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.mapping.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> createReview(
            @PathVariable Long storeId,
            @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO dto) {

        Review saved = reviewCommandService.createReview(storeId, dto);
        ReviewResponseDTO.CreateResultDTO response = ReviewConverter.toCreateResultDTO(saved);

        return ApiResponse.onSuccess(response);
    }

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "page 쿼리 파라미터로 페이징 처리된 리뷰 목록을 반환합니다.")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getMyReviews(@RequestParam(name = "page") int page) {
        return ApiResponse.onSuccess(reviewQueryService.getMyReviews(1L, page));
    }
}
