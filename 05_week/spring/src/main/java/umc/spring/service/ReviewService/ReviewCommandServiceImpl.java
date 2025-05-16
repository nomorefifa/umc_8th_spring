package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.mapping.Member;
import umc.spring.domain.mapping.Review;
import umc.spring.domain.mapping.Store;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review createReview(Long storeId, ReviewRequestDTO.CreateReviewDTO dto) {

        Member member = memberRepository.findById(1L) // 하드코딩, userID가 1인 사람으로 지정
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("가게 없음"));

        Review review = ReviewConverter.toReview(dto, member, store);

        return reviewRepository.save(review);
    }
}
