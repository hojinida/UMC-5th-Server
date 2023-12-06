package com.example.mission7.mission;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MissionProgress {
    String message() default "가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}