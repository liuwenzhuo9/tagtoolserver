package com.example.tagtool.tagController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthController {
    AuthLevel value() default AuthLevel.ALL;

    AuthLevel level() default AuthLevel.ALL;

    int role() default 0;

    int[] roles() default {};
}
