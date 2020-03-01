package com.imooc.byennsix.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.byennsix.domain.entity.Sku;
import com.imooc.byennsix.service.CartService;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wjy
 * @Date: 2020/3/1 14:51
 * 常见于定义的收集器的使用
 */
public class StreamCollector {

    /**
     * 将最终的流转换成一个集合
     */
    @Test
    public void toListTest() {
        List<Sku> cartList = CartService.getCartSkuList();
        List<String> collect = cartList.stream().map(sku -> sku.getSkuName()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect,true));
    }

    /**
     * 将最终的流进行分组
     */
    @Test
    public void groupTest() {
        List<Sku> cartList = CartService.getCartSkuList();
        Map<String, List<Sku>> collect = cartList.stream().collect(Collectors.groupingBy(sku -> sku.getCategory()));
        System.out.println(JSON.toJSONString(collect,true));
    }

    @Test
    public void partitionTest() {
        List<Sku> cartList = CartService.getCartSkuList();
        Map<Boolean, List<Sku>> collect = cartList.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 1000));
        System.out.println(JSON.toJSONString(collect,true));
    }

    @Test
    public void maxByTest() {
        List<Sku> cartList = CartService.getCartSkuList();
        Double collect = cartList.stream().collect(Collectors.averagingDouble(Sku::getTotalPrice));
        System.out.println(collect);
    }
}
