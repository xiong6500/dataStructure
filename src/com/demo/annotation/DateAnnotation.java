package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 处理日期的注解
 * 给日期设置
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateAnnotation {
    public String value() default "";
    public String pattern() default "yyyy-MM-dd HH:mm:ss";

}
