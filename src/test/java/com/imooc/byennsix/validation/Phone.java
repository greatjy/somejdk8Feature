package com.imooc.byennsix.validation;

/**
 * @Author: wjy
 * @Date: 2020/3/6 0:37
 * 自定义手机号约束注解
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义手机号注解
 *
 */
@Documented
// 注解的作用目标：属性
@Target({ElementType.FIELD})
// 注解的保留策略
@Retention(RetentionPolicy.RUNTIME)
// 位当前注解指定验证器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    // 约束注解错误时的提示信息
    String message() default "手机号格式不正确";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload() default {};
}
