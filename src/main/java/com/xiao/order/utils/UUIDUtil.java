package com.xiao.order.utils;

import java.util.UUID;

/**
 * @author XYW
 * @create 2020-05-11 10:46
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
