package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.Mission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResponseDTO.MissionListDTO getMissionList(Long memberId, MissionStatus status) {
        List<MemberMission> missions = memberMissionRepository.findByMemberIdAndStatus(memberId, status);
        return MissionConverter.toListDTO(missions);
    }

    private final MissionRepository missionRepository;

    @Override
    public MissionResponseDTO.MissionPreviewListDTO getMissionsByStore(Long storeId, int page) {
        Pageable pageable = PageRequest.of(page, 5); // 페이지 크기 5
        Page<Mission> missionPage = missionRepository.findAllByStoreId(storeId, pageable);
        return MissionConverter.toStoreMissionPreviewListDTO(missionPage);
    }
}
