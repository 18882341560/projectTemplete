package com.fangfa.projecttemplate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 11
 * @Remarks  该注解用于记录操作日志，只能用于方法上，在控制层使用
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Operateion {
    String value() default "";
}
