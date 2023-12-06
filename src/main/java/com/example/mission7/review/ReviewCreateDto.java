package com.example.mission7.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReviewCreateDto {
    private Long storeId;
    private String content;
    private Float score;
}
