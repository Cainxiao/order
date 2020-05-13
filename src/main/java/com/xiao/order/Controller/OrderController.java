package com.xiao.order.Controller;

import com.xiao.order.VO.ResultVO;
import com.xiao.order.dto.OrderDTO;
import com.xiao.order.enums.ResultEnum;
import com.xiao.order.exception.OrderException;
import com.xiao.order.form.OrderForm;
import com.xiao.order.service.OrderService;
import com.xiao.order.utils.OrderForm2OrderDTO;
import com.xiao.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XYW
 * @create 2020-05-09 16:32
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 1.参数校验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存（调用商品服务）
     * 5.订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                           BindingResult bindingResult){
        /**
         * 参数校验有误
         */
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(bindingResult.getFieldError().getDefaultMessage(),ResultEnum.PARAM_ERROR.getCode());
        }

        //orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        //返回信息
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);


    }
}
