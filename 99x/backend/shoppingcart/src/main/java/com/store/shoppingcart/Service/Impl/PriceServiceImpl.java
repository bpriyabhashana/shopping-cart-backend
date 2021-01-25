package com.store.shoppingcart.Service.Impl;

import com.store.shoppingcart.Dto.CartPriceMap;
import com.store.shoppingcart.Dto.PriceListMap;
import com.store.shoppingcart.Enumz.ResponseMessage;
import com.store.shoppingcart.Model.Product;
import com.store.shoppingcart.Response.Response;
import com.store.shoppingcart.Service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    private static final Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);

    //Get product price for all items
    @Override
    public Object getAllItems() {

        return new Response(ResponseMessage.SUCCESS, HttpStatus.OK, mockProductDatabase());
    }


    //Calculate the cart price
    @Override
    public Object getCartPrice(int penguinUnits, int horseUnits) {
        List<Product> products = mockProductDatabase();
        List<CartPriceMap> cartPriceMaps = new ArrayList<>();
        CartPriceMap priceMap = new CartPriceMap();
        double penguinTotalPrice =   getPriceByAmountAndProduct(products.get(0).getCartonPrice(), penguinUnits, products.get(0).getCartonAmount());
        double horseTotalPrice = getPriceByAmountAndProduct(products.get(1).getCartonPrice(), horseUnits, products.get(1).getCartonAmount());
        double totalCartPrice = penguinTotalPrice + horseTotalPrice;

        priceMap.setPenguinTotalPrice(penguinTotalPrice);
        priceMap.setHorseTotalPrice(horseTotalPrice);
        priceMap.setTotalCartPrice(totalCartPrice);

        return new Response(ResponseMessage.SUCCESS, HttpStatus.OK, priceMap);
    }

    //Get item price list for table
    @Override
    public Object getTableItems() {
        return new Response(ResponseMessage.SUCCESS, HttpStatus.OK, getProductPriceMap(mockProductDatabase()));
    }

    private List<PriceListMap> getProductPriceMap(List<Product> products){
        List<PriceListMap> priceTable = new ArrayList<>();

        for (int i=1; i<51; i++ ) {

                PriceListMap priceTableMap = new PriceListMap();
                priceTableMap.setAmount(i);

                priceTableMap.setPricePenguin(getPriceByAmountAndProduct(products.get(0).getCartonPrice(), i, products.get(0).getCartonAmount()));
                priceTableMap.setPriceHorse(getPriceByAmountAndProduct(products.get(1).getCartonPrice(), i, products.get(1).getCartonAmount()));
                priceTable.add(priceTableMap);

        }

        return  priceTable;

    }

    private List<Product> mockProductDatabase(){
        List<Product> productList = new ArrayList<>();
        Product penguinEars = new Product();
        penguinEars.setProductId("Penguin-ears");
        penguinEars.setCartonPrice(175);
        penguinEars.setImageUrl("https://png.pngtree.com/template/20190716/ourlarge/pngtree-illustration-penguin-cute-icon-logo-vector-animals-image_228229.jpg");
        penguinEars.setCartonAmount(20);
        productList.add(penguinEars);

        Product horseshoe = new Product();
        horseshoe.setProductId("Horseshoe");
        horseshoe.setCartonPrice(825);
        horseshoe.setCartonAmount(5);
        horseshoe.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTX0O2bkbB_4TJho1HcutoNoSlpMnzJ3WmLcw&usqp=CAU");
        productList.add(horseshoe);
        return productList;
    }

    private double getPriceByAmountAndProduct(double cartonPrice, int amount, int cartonAmount){
        int cartons = amount/cartonAmount;
        int units = amount % cartonAmount;
        double unitPrice = (cartonPrice/cartonAmount) * 1.3;
        double totalCartonPrice = cartons * cartonPrice;
        double cartonDiscount = 0;

        if (cartons > 2){
            cartonDiscount = cartonPrice * 0.1 * cartons;
        }
        double totalUnitPrice = units * unitPrice;
        return Math.round((totalCartonPrice - cartonDiscount + totalUnitPrice) * 100.0) / 100.0 ;
    }



    public Object getPriceList(){
        return null;
    }
}
