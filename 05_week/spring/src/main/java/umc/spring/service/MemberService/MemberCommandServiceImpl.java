package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.mapping.FoodCategory;
import umc.spring.domain.mapping.Member;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.converter.MemberConverter;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        // 1. Member 생성
        Member newMember = MemberConverter.toMember(request);

        // 2. 선호 카테고리 ID → FoodCategory Entity 리스트 조회
        List<FoodCategory> foodCategories = request.getPreferCategory().stream()
                .map(id -> foodCategoryRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리 ID: " + id)))
                .toList();

        // 3. MemberPrefer 리스트 생성
        List<MemberPrefer> memberPrefers = MemberPreferConverter.toMemberPreferList(foodCategories);

        // 4. 연관관계 연결 (memberPrefer.setMember)
        memberPrefers.forEach(mp -> mp.setMember(newMember));

        // 5. member에 리스트 설정
        newMember.getMemberPreferList().addAll(memberPrefers);

        // 6. DB 저장
        return memberRepository.save(newMember);
    }
}