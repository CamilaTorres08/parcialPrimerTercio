package edu.eci.cvds.parcial;

import org.springframework.stereotype.Component;

@Component
public interface Observer {
    public void update(Product product);
}
