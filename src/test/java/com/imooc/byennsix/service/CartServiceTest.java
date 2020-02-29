package com.imooc.byennsix.service;

import com.alibaba.fastjson.JSON;
import com.imooc.byennsix.domain.entity.Sku;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author: wjy
 * @Date: 2020/2/27 21:04
 */
public class CartServiceTest {

    @Test
    public void filterSkuByCategory() {
        List<Sku> cartList = CartService.getCartSkuList();
        String category = "clothes";
        List<Sku> result = CartService.filterSkusByCategory(cartList,category);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void filterSkuByCatOrPrice() {
        List<Sku> cartList = CartService.getCartSkuList();
        String category = "clothes";
        List<Sku> result = CartService.filterSkuByCategoryOrPrice(cartList,Boolean.FALSE,category,1999.0,5000.0);
        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void filterSkyBySkuValidate() {
        List<Sku> cartList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkuBySkuValidate(cartList, new SkuValidate() {
            @Override
            public boolean verrifySku(Sku sku) {
                if(sku.getCategory() != null && sku.getCategory().equals("book")) {
                    return true;
                }
                return false;
            }
        });
        System.out.println(JSON.toJSONString(result,true));
    }

    @Test
    public void filterSkyBySkuValidate_lambda() {
        List<Sku> cartList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkuBySkuValidate(cartList,
                (Sku sku) -> sku.getTotalPrice() > 1000);
        System.out.println(JSON.toJSONString(result,true));
    }
}
