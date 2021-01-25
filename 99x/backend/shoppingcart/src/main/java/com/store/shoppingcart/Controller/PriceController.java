package com.store.shoppingcart.Controller;

import com.store.shoppingcart.Response.Response;
import com.store.shoppingcart.Response.ResponseController;
import com.store.shoppingcart.Service.PriceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class PriceController extends ResponseController {
    private static final Logger logger = LoggerFactory.getLogger(PriceController.class);

    private final PriceService priceService;
    public PriceController(PriceService priceService){this.priceService = priceService;}

    @ApiOperation(value = "Get all items", notes = "Get all items of store")
    @ApiResponse(code = 200, message = "Success", response = Response.class)
    @GetMapping("/allItems")
    public ResponseEntity<Object> getPrice(){
        logger.info("HIT - GET /items");
        return sendResponse(priceService.getAllItems());
    }

    @ApiOperation(value = "Get all items", notes = "Get all items of store")
    @ApiResponse(code = 200, message = "Success", response = Response.class)
    @GetMapping("/tableItems")
    public ResponseEntity<Object> getTableItems(){
        logger.info("HIT - GET /tableItems");
        return sendResponse(priceService.getTableItems());
    }

    @ApiOperation(value = "Get cart price", notes = "Get selected cart price")
    @ApiResponse(code = 200, message = "Success", response = Response.class)
    @GetMapping("/cartPrice")
    public ResponseEntity<Object> getCartPrice(@RequestParam("penguinUnits") int penguinUnits,
                                               @RequestParam("horseUnits") int horseUnits){
        logger.info("HIT - GET /cartPrice ---> getAllItems | penguinUnits: {}, horseUnits : {}", penguinUnits, horseUnits);
        return sendResponse(priceService.getCartPrice(penguinUnits, horseUnits));
    }
}
