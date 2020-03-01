package com.imooc.byennsix.stream;


import com.alibaba.fastjson.JSON;
import com.imooc.byennsix.domain.entity.Sku;
import com.imooc.byennsix.service.CartService;
import org.assertj.core.api.OptionalAssert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.*;

/**
 * @Author: wjy
 * @Date: 2020/2/29 23:14
 */
public class StreamOperation {

    List<Sku> cartSkuList = null;
    @Before
    public void init() {
        cartSkuList = CartService.getCartSkuList();
    }

    // 无状态  不存在数据保存功能  线程安全
    @Test
    public void filterTest() {
        cartSkuList.stream()
                .filter((Sku sku) -> sku.getCategory().equals("book"))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku,true)));
    }

    @Test
    public void mapTest() {
        cartSkuList.stream()
                .map(sku -> sku.getSkuName())
                .forEach(sku-> System.out.println(JSON.toJSONString(sku,true)));
    }

    @Test
    public void flatMapTest() {
        cartSkuList.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(sku-> System.out.println(JSON.toJSONString(sku,true)));
    }

    @Test
    public void peekTest() {
        cartSkuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(sku-> System.out.println(JSON.toJSONString(sku,true)));
    }


    //有状态 存在数据保存功能  线程不安全

    @Test
    public void sortTest() {
        cartSkuList.stream()
                .sorted(Comparator.comparing(Sku :: getTotalPrice,Comparator.reverseOrder()))
                .forEach(sku-> System.out.println(JSON.toJSONString(sku,true)));
    }

    @Test
    public void distinctTest() {
        cartSkuList.stream()
                .map(sku -> sku.getCategory())
                .distinct()
                .forEach(sku-> System.out.println(JSON.toJSONString(sku,true)));
    }

    @Test
    public void skipTest() {
        cartSkuList.stream()
                .sorted(Comparator.comparing(sku -> sku.getTotalPrice(),Comparator.reverseOrder()))
                .skip(3)
                .forEach(sku-> System.out.println(JSON.toJSONString(sku,true)));
    }

    @Test
    public void limitTest() {
        cartSkuList.stream()
                .sorted(Comparator.comparing(sku -> sku.getTotalPrice(),Comparator.reverseOrder()))
                .limit(3)
                .forEach(sku-> System.out.println(JSON.toJSONString(sku,true)));
    }
    //终端操作 会消耗元素 只能有一个终端操作 是指返回最终的结果。
    // 一个流只能有一个terminal操作，当这个操作执行后，流就被使用“光”了，无法再被操作。

    @Test
    public void allMatchTest() {
        boolean b = cartSkuList.stream().allMatch(sku -> sku.getSkuName() != null);
        System.out.println(b);
    }

    @Test
    public void anyMatch() {
        boolean b = cartSkuList.stream()
                .anyMatch(sku -> sku.getTotalPrice() > 1999);
        System.out.println(b);
    }

    @Test
    public void noneMatchTest() {
        boolean b = cartSkuList.stream()
                .noneMatch(sku -> sku.getTotalPrice() > 10000);
        System.out.println(b);
    }

    @Test
    public void findFirstTest() {
        Optional<Sku> first =
                cartSkuList.stream()
                        .sorted(Comparator.comparing(sku -> sku.getTotalPrice(), Comparator.reverseOrder()))
                        .findFirst();
        System.out.println(JSON.toJSONString(first.get(),true));
    }

    @Test
    public void findAnyTest() {
        Optional<Sku> any = cartSkuList.stream()
                .sorted(Comparator.comparing(sku -> sku.getTotalPrice(), Comparator.reverseOrder()))
                .findAny();
        System.out.println(JSON.toJSONString(any,true));

    }

    @Test
    public void maxPriceTest() {
        OptionalDouble max =
                cartSkuList.stream().
                        mapToDouble(Sku::getTotalPrice).
                        max();
        System.out.println(max.getAsDouble());
    }

    @Test
    public void minPriceTest() {
        OptionalDouble min = cartSkuList.stream().mapToDouble(Sku::getTotalPrice).min();
        System.out.println(min.getAsDouble());
    }

    @Test
    public void countTest() {
        cartSkuList.stream()
                .count();
    }
}
