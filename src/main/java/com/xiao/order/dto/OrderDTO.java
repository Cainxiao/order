package com.xiao.order.dto;

import com.xiao.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author XYW
 * @create 2020-05-11 10:22
 */
@Data
public class OrderDTO {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 卖家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 支付状态
     */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;

}
