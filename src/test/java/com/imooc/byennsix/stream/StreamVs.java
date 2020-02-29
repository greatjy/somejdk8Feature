package com.imooc.byennsix.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.byennsix.domain.entity.Sku;
import com.imooc.byennsix.service.CartService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 本測試類主要是为了展示原始集合操作与使用stream流之后的集合操作
 * @Author: wjy
 * @Date: 2020/2/29 0:12
 */
public class StreamVs {

    /**
     *  需求1. 查看当前购物车中的所有商品
     *  2. 图书类的商品都返回true
     *  3. 其余商品购买两件最贵的
     */

    @Test
    public void oldCartHandle(){
        List<Sku> cartList = CartService.getCartSkuList();
        //1 打印所有商品 2获取到过滤掉图书的商品集合
        List<Sku> filterBookList = new ArrayList<>();
        for(Sku sku : cartList) {
            System.out.println(JSON.toJSONString(sku,true));
            if(!(sku.getCategory().equals("book"))) {
                filterBookList.add(sku);
            }
        }

        // 对过滤掉图书的集合进行排序
        Collections.sort(filterBookList, new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if(sku1.getTotalPrice() > sku2.getTotalPrice()) {
                    return -1;
                }
                else if(sku1.getTotalPrice() < sku2.getTotalPrice()) {
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });

        //创建top2集合 和 top2名称集合
        List<Sku> top2SkuList = new ArrayList<>();
        List<String> top2SkuNameList = new ArrayList<>();
        Double totalMoney = 0.0;

        for(int i=0; i<2; i++) {
            Sku sku = filterBookList.get(i);
            top2SkuList.add(sku);
            totalMoney += sku.getTotalPrice();
            top2SkuNameList.add(sku.getSkuName());
        }

        System.out.println(JSON.toJSONString(top2SkuNameList,true));
        System.out.println(totalMoney);
    }

    @Test
    public void streamCartHandle() {
        List<Sku> cartList = CartService.getCartSkuList();
        AtomicReference<Double> money  = new AtomicReference<>(Double.valueOf(0.0));
        List<String> skuNameList = cartList.stream()
                // 打印商品信息
                .peek((Sku sku) -> System.out.println(JSON.toJSONString(sku, true)))
                // 过滤掉图书
                .filter((Sku sku) -> !sku.getCategory().equals("book"))
                // 商品总价排序 传入需要比较属性的方法接口 reversed表示从大到小
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                // 挑出前两个商品
                .limit(2)
                // 计算这两个商品总价
                .peek((Sku sku) -> money.set(sku.getTotalPrice() + money.get()))
                // 获取两件商品的商品名称
                .map((Sku sku) -> sku.getSkuName())
                //  收集这两件商品的名称
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(skuNameList,true));
        System.out.println(money.get());
    }
}
