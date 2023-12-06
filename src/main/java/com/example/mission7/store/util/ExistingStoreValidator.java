package com.example.mission7.store.util;


import com.example.mission7.store.domain.Store;
import com.example.mission7.store.domain.repository.StoreRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExistingStoreValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(StoreExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        Store store = storeRepository.findById(storeId).orElse(null);
        return store != null;
    }
}
