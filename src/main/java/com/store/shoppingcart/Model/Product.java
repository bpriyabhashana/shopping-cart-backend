package com.store.shoppingcart.Model;

public class Product {
    private String productId;
    private double cartonPrice;
    private int cartonAmount;
    private String imageUrl;

    public int getCartonAmount() {
        return cartonAmount;
    }

    public void setCartonAmount(int cartonAmount) {
        this.cartonAmount = cartonAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
