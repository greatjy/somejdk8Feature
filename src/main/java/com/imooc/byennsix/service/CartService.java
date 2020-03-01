package com.imooc.byennsix.service;

import com.imooc.byennsix.domain.entity.Sku;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: wjy
 * @Date: 2020/2/26 22:44
 */
@Service
public class CartService {
    /**
     * 所有商品的购物车集合 并将其初始化
     */
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(1, "wurenji", 1999.0, 1, 1999.0,"elect"));
            add(new Sku(2, "vr", 2999.0, 1,2999.0,"elect"));
            add(new Sku(3, "跑步机", 4999.0, 1, 4999.0, "sport"));
            add(new Sku(4, "算法", 99.0, 1, 99.0, "sport"));
            add(new Sku(5, "Java", 89.0, 1, 89.0, "book"));
            add(new Sku(6, "衬衫", 199.0, 1, 199.0, "clothes"));
            add(new Sku(7, "裤子", 299.0, 1, 299.0,"clothes"));
        }
    };

    /**
     * 返回商品购物车列表
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * version 1.0 foreach版本
     * 找出电子产品类别的商品列表
     *
     * @param cartSkuList 购物车列表
     * @return 电子产品类别的商品列表
     */
    public static List<Sku> filterElectornicsSkus(List<Sku> cartSkuList) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if("elect".equals(sku.getCategory())) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * 根据商品类型找出对应商品列表
     */
    public static List<Sku> filterSkusByCategory(List<Sku> cartSkuList, String category) {
        if(category == null || category.length() == 0) {
            return null;
        }
        List<Sku> result = new ArrayList<>();
        for(Sku sku: cartSkuList) {
            if(category.equals(sku.getCategory())) {
                result.add(sku);
            }
        }
        return result;
    }

    public static List<Sku> filterSkuByCategoryOrPrice(List<Sku> cartSkuList, Boolean priceflag,
                                                       String category, Double priceLower, Double priceUpper ) {
        List<Sku> result = new ArrayList<>();
        if(priceflag) {
            //按照category 进行分类
            for(Sku sku: cartSkuList) {
                if(category != null && category.equals(sku.getCategory())) {
                    result.add(sku);
                }
            }
        }
        else {
            if(priceUpper != null && priceLower != null) {
                for (Sku sku : cartSkuList) {
                    if(priceLower < sku.getTotalPrice() && priceUpper > sku.getTotalPrice()) {
                        result.add(sku);
                    }
                }
            }
        }
        return result;
    }

    public static List<Sku> filterSkuBySkuValidate(List<Sku> cartSkuList, SkuValidate skuValidate) {
        List<Sku> result = new ArrayList<>();
        for(Sku sku : cartSkuList) {
            if(skuValidate.verrifySku(sku)) {
                result.add(sku);
            }
        }
        return result;
    }

    public static void main(String[] args) throws RuntimeException {
        Optional<String> notnull = Optional.of("beijing university of posts and telecommunications");
        notnull.orElseThrow(()-> new RuntimeException(">>"));
    }


}
