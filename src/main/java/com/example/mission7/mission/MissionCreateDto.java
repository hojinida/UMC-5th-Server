package com.example.mission7.mission;

import lombok.Getter;

@Getter
public class MissionCreateDto {
    private Long storeId;

    public MissionCreateDto(Long storeId) {
        this.storeId = storeId;
    }
}
