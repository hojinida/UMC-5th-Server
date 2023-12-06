package com.example.mission7.store.application;


import com.example.mission7.region.Region;
import com.example.mission7.region.domain.RegionRepository;
import com.example.mission7.store.domain.Store;
import com.example.mission7.store.domain.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    public void createStore(Long regionId) {
       Region region = regionRepository.findById(regionId).orElseThrow();
       Store store = Store.builder()
                       .region(region).build();
       storeRepository.save(store);
    }
}
