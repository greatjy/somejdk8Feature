package com.imooc.byennsix.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wjy
 * @Date: 2020/3/6 0:43
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 定义正则表达式验证手机
        String check = "158\\d{8}";
        Pattern regrex = Pattern.compile(check);
        Matcher matcher = regrex.matcher(s);
        return matcher.matches();
    }
}
