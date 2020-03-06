package com.imooc.byennsix.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: wjy
 * @Date: 2020/3/4 9:40
 * 验证测试类
 */
public class ValidationTest {
    // 验证器对象
    private Validator validator;
    // 待验证对象
    private UserInfo userInfo;

    // 验证结果集
    private Set<ConstraintViolation<UserInfo>> validationResultSet;

    //初始化操作
    @Before
    public void init() {
        //初始化验证器
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        //初始化待验证对象
        userInfo = new UserInfo();
        userInfo.setUserId("wangweijia");
        userInfo.setUserPassword("123456");
        userInfo.setUserName("maobuyi");
        userInfo.setUserEmail("wjystu.ouc.edu.cn");
        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(new UserInfo());
        userInfo.setUserFriendsList(list);
    }

    //最后打印操作
    @After
    public void pirnt() {
         for(ConstraintViolation<UserInfo> item : validationResultSet) {
             System.out.println(item.getMessage());
         }
    }

    @Test
    public void notNullValidate() {
        //使用验证器对对象进行验证  返回值时验证有问题的信息
        validationResultSet = validator.validate(userInfo);
    }

    @Test
    public void testScope() {
        validationResultSet = validator.validate(userInfo);
    }



}
