package com.xiao.order.repository;

import com.xiao.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XYW
 * @create 2020-05-09 16:21
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
