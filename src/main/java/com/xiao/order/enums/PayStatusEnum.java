package com.xiao.order.enums;

import lombok.Getter;

/**
 * @author XYW
 * @create 2020-05-09 16:28
 */
@Getter
public enum  PayStatusEnum {
    WAIT(0, "等待支付"),
    FINISHED(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
