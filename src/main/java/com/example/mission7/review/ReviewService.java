package com.example.mission7.review;

import com.example.mission7.store.domain.Store;
import com.example.mission7.store.domain.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    public void createReview(ReviewCreateDto requestDto) {
        Optional<Store> store = storeRepository.findById(requestDto.getStoreId());
        Review review = Review.builder().score(requestDto.getScore())
                .content(requestDto.getContent()).build();
        store.get().addReview(review);
        reviewRepository.save(review);

    }
}
