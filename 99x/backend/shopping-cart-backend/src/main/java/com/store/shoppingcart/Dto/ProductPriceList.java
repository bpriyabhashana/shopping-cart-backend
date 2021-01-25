package com.store.shoppingcart.Dto;

import java.util.List;

public class ProductPriceList {
    private String productId;
    private List<ProductPriceMap> productPriceMap;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<ProductPriceMap> getProductPriceMap() {
        return productPriceMap;
    }

    public void setProductPriceMap(List<ProductPriceMap> productPriceMap) {
        this.productPriceMap = productPriceMap;
    }
}
