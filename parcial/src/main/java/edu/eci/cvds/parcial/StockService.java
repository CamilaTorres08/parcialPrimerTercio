package edu.eci.cvds.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StockService {
    HashMap<String,Product> products;
    Observer advertencyAgent;
    Observer logAgent;

    @Autowired
    public StockService(Observer advertencyAgent, Observer logAgent){
        products = new HashMap<>();
        this.advertencyAgent = advertencyAgent;
        this.logAgent = logAgent;
    }

    public void addProduct(Product product){
        if (product != null) {
            products.put(product.getName(), product);
            product.addObserver(advertencyAgent);
            product.addObserver(logAgent);
        }
    }
    /*
    *Actualiza el estado y retorna booleano indicando si se actualizó o no
     */
    public boolean updateStock(String nameProduct, int quantity){
        if (nameProduct != null && quantity > 0){
            Product product = products.get(nameProduct);
            if (product != null){
                product.setQuantity(quantity);
                return true;
            }
            return false;
        }
        return false;
    }
    public HashMap<String,Product> getProducts(){
        return products;
    }
    public void deleteProduct(Product product){
        if(product != null) {
            products.remove(product.getName());
        }
    }

    }

