package com.imooc.byennsix.domain.entity;


/**
 * @Author: wjy
 * @Date: 2020/2/24 16:08
 * 下单商品信息对象
 */
public class Sku {
    /**
     * 商品id
     */
    private Integer skuId;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 商品单价
     */
    private Double skuPrice;

    /**
     * 商品购买个数
     */
    private Integer totalNum;

    /**
     * 商品购买总价
     */
    private Double totalPrice;

    /**
     * 商品类型，使用枚举类定义
     */
    // private SkuCategoryEnum skuCategory;
    private String category;


    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, String category) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.category = category;
    }

    public Integer getSkuId() {

        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
