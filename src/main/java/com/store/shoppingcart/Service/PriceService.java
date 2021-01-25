package com.store.shoppingcart.Service;

public interface PriceService {
    Object getAllItems();
    Object getCartPrice(int penguinUnits, int horseUnits);

    Object getTableItems();
}
