package com.xiao.order.service.impl;

import com.xiao.order.dataobject.OrderMaster;
import com.xiao.order.dto.OrderDTO;
import com.xiao.order.enums.OrderStatusEnum;
import com.xiao.order.enums.PayStatusEnum;
import com.xiao.order.repository.OrderDetailRepository;
import com.xiao.order.repository.OrderMasterRepository;
import com.xiao.order.service.OrderService;
import com.xiao.order.utils.TimeUtil;
import com.xiao.order.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author XYW
 * @create 2020-05-11 10:33
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO 查询商品信息（调用商品服务）

        //TODO 计算总价

        //TODO 扣库存（调用商品服务）

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(UUIDUtil.getUUID());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(TimeUtil.getCurrentDate());
        orderMaster.setUpdateTime(TimeUtil.getCurrentDate());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
