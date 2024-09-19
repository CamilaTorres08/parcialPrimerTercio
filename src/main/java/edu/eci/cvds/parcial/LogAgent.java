package edu.eci.cvds.parcial;

import org.springframework.stereotype.Component;

@Component
public class LogAgent implements Observer{
    public void update(Product product){
        System.out.println(product.getName() + " -> " + product.getQuantity() + " available ");
    }
}
