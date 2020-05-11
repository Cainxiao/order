package com.xiao.order.exception;

import com.xiao.order.enums.ResultEnum;

/**
 * @author XYW
 * @create 2020-05-11 11:06
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }



}
