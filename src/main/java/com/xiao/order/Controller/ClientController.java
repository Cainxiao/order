package com.xiao.order.Controller;

import com.xiao.order.client.ProductClient;
import com.xiao.order.dataobject.ProductInfo;
import com.xiao.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author XYW
 * @create 2020-05-12 11:18
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;
//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

        //第一种方式（固定地址）
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);
//        log.info("response={}",response);
//        return response;

        //第二种方式（利用loadBalancerClient通过应用名获取url）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()) + "/msg";
//        String response = restTemplate.getForObject(url,String.class);
//        log.info("response={}",response);
//        return response;

        //第三种方式 (利用@LoadBalanced，可以使用restTemplate里使用应用名字)
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
//        log.info("response={}",response);
//        return response;
        String response = productClient.productMsg();
        log.info("response={}",response);
        return response;

    }


    /**
     * @GetMapping("/getProductList")
     * 用了requesrBody就不能用Get需要用Post
     * 以下情况可以用Get
     * 无参、单个参数使用@RequestParam、@Pathvariable
     * @return
     */
    @GetMapping("/getProductList")
    public String  getProductList() {
        List<ProductInfo> response = productClient.listForOrder(Arrays.asList("157875196366160022"));
        log.info("response={}",response);
        return "ok";
    }


    /**
     * 扣库存
     */
    @GetMapping("/decreaseStock")
    public String decreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 3)));
        return "ok";
    }
}
