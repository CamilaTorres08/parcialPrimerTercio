package edu.eci.cvds.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping ("deleteProduct")
    public void deleteProduct(@RequestBody Product product){
        stockService.deleteProduct(product);
    }

}
