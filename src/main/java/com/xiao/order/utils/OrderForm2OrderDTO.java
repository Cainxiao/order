package com.xiao.order.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiao.order.dataobject.OrderDetail;
import com.xiao.order.dto.OrderDTO;
import com.xiao.order.enums.ResultEnum;
import com.xiao.order.exception.OrderException;
import com.xiao.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 将orderForm转成orderDTO
 *
 * @author XYW
 * @create 2020-05-11 11:19
 */
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenId());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        //引入google的gson操作组件
        Gson gson = new Gson();

        //将String类型的item转成List
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误，string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
