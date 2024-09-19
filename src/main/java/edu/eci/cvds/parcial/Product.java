package edu.eci.cvds.parcial;

import java.util.ArrayList;
import java.util.List;

public class Product extends Agent{

    String name;
    double price;
    int quantity;
    String category;
    List<Observer> observers;

    public Product(String name, double price, int quantity, String category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        observers = new ArrayList<>();
    }

    public void notifyObservers(){
        for(Observer o: observers){
            o.update(this);
        }
    }
    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }
    public List<Observer> getObservers(){
        return observers;
    }

    public String getName(){
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }
    public String getCategory(){
        return category;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
        notifyObservers();
    }


}
