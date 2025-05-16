package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.mapping.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
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
}
