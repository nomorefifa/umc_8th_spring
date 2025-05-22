package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.mapping.Member;
import umc.spring.domain.mapping.Review;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public ReviewResponseDTO.ReviewPreviewListDTO getMyReviews(Long memberId, int page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        Pageable pageable = PageRequest.of(page, 5);
        Page<Review> reviewPage = reviewRepository.findAllByMemberId(member.getId(), pageable);

        return ReviewConverter.toPreviewListDTO(reviewPage);
    }
}
