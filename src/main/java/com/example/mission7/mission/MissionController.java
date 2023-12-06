package com.example.mission7.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;
    @PostMapping("/mission")
    public ResponseEntity<SuccessResponseDto> createMission(@RequestBody MissionCreateDto requestDto) {
        return ResponseEntity.ok().body(missionService.createMission(requestDto));
    }

    @PatchMapping("/mission")
    public ResponseEntity<SuccessResponseDto> createMemberMission(@MissionProgress @RequestBody MemberMissionProgressDto requestDto) {
        return ResponseEntity.ok().body(missionService.changeMissionStatus(requestDto));
    }
}
