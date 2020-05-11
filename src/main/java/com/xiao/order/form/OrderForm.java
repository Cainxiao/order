package com.xiao.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 表单校验对象
 *
 * @author XYW
 * @create 2020-05-11 10:55
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家电话
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openId
     */
    @NotEmpty(message = "openId必填")
    private String openId;

    /**
     * 买家购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
