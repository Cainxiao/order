package com.xiao.order.repository;

import com.xiao.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XYW
 * @create 2020-05-09 16:18
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}
