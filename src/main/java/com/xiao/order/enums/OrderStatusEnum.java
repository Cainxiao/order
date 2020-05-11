package com.xiao.order.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * @author XYW
 * @create 2020-05-09 14:16
 */
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2,"取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
