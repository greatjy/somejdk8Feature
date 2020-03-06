package com.imooc.byennsix.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Author: wjy
 * @Date: 2020/3/4 9:39
 * 验证框架测试信息基础验证类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private String userId;

    /**
     * 用户名
     */
    @NotEmpty()
    private String userName;

    /**
     * 用户密码
     */
    @NotBlank
    @Length(min = 6, max = 20, message = "密码不能少于6位，不能大于20位")
    private String userPassword;

    /**
     * 用户邮箱
     */
    @Email(message = "email邮箱格式不正确")
    private String userEmail;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户生日
     */
    private Date userBirthDate;

    /**
     * 用户好友列表
     */
    private List<@Valid UserInfo> userFriendsList;
}
