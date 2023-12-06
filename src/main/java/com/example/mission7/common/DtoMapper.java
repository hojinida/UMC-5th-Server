package com.example.mission7.common;

import com.example.mission7.mission.Mission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoMapper {
        Mission toMissionDto(SuccessResponseDto successResponseDto);
}
