package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.web.dto.MemberMissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResponseDTO.OngoingMissionListDTO getMyMissionListByStatus(Long memberId, MissionStatus status, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<MemberMission> missions = memberMissionRepository.findAllByMemberIdAndStatus(memberId, status, pageable);
        return MemberMissionConverter.toListDTO(missions);
    }
}