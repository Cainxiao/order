package com.xiao.order.service;

import com.xiao.order.dto.OrderDTO;

/**
 * @author XYW
 * @create 2020-05-11 10:19
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
