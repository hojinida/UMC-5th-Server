package com.example.mission7.review;

import com.example.mission7.store.util.StoreExists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @PostMapping("/review")
    public void createReview(@StoreExists @RequestBody ReviewCreateDto requestDto) {
        reviewService.createReview(requestDto);
    }
}
