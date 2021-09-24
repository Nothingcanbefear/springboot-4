package com.ggg.mybatisplus.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopAnnotation {
    String value() default "";
}
