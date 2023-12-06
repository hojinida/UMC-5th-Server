package com.example.mission7.mission;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MissionInProgressValidator implements ConstraintValidator<MissionProgress, Long> {
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        Optional<MemberMission> memberMission = memberMissionRepository.findById(id);
        // 미션 상태가 "진행 중"이면 유효하다고 판단합니다.
        return memberMission.get()!=null && memberMission.get().equals("진행 중");
    }

    @Override
    public void initialize(MissionProgress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

}
