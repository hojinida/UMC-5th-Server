package com.example.mission7.store.util;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StoreExists {
    String message() default "가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
