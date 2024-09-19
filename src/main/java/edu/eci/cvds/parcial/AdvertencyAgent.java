package edu.eci.cvds.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvertencyAgent implements Observer{
    public void update(Product product){
        if (product.getQuantity() <= 4){
            System.out.println("ALERT!! the stock of the product " + product.getName() + " is very low only " + product.getQuantity() + "units.");
        }
    }
}
