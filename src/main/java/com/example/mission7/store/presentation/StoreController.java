package com.example.mission7.store.presentation;

import com.example.mission7.store.application.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/store")
    public void createStore(@RequestParam Long regionId) {
        storeService.createStore(regionId);
    }



}
