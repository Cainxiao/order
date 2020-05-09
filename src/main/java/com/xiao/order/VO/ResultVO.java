package com.xiao.order.VO;

import lombok.Data;

/**
 * @author XYW
 * @create 2020-05-09 14:29
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
     private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回内容
     */
     private T data;
}
