package com.example.mission7.mission;

import com.example.mission7.common.ResponseConverter;
import com.example.mission7.store.domain.Store;
import com.example.mission7.store.domain.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public SuccessResponseDto createMission(MissionCreateDto requestDto) {
        Store store = storeRepository.findById(requestDto.getStoreId()).orElseThrow();
        Mission mission = Mission.builder().build();
        store.addMission(mission);
        missionRepository.save(mission);

        return ResponseConverter.toSuccessResponseDto();
    }

    public SuccessResponseDto changeMissionStatus(MemberMissionProgressDto requestDto) {
        MemberMission memberMission = memberMissionRepository.findById(requestDto.getMissionId()).orElseThrow();
        memberMission.setStatus("진행중");
        return ResponseConverter.toSuccessResponseDto();
    }
}
