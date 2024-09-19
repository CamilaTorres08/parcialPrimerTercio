package edu.eci.cvds.parcial;
import java.util.ArrayList;
import java.util.List;
public abstract class Agent {

    List<Observer> observers;
    public Agent(){
        observers = new ArrayList<>();
    }
    public abstract void notifyObservers();
    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }
    public List<Observer> getObservers(){
        return observers;
    }
}
