package edu.eci.cvds.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/stock")
public class StockController {
    StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @PostMapping ("addProduct")
    public void addProduct(@RequestBody Product product) {
        stockService.addProduct(product);
    }

    @PutMapping("updateStock")
    public void updateStock(@RequestParam String name, @RequestParam int quantity) {
        stockService.updateStock(name,quantity);
    }
    @GetMapping("getProduct")
    public HashMap<String,Product> getProducts(){
        return stockService.getProducts();
    }


}
