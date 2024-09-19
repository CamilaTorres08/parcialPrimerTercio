package edu.eci.cvds.parcial;
import java.util.List;
public abstract class Agent {

    public abstract void notifyObservers();
    public abstract void addObserver(Observer observer);
    public abstract void removeObserver(Observer observer);
}
