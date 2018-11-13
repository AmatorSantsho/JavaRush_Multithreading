package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by 123 on 30.09.2017.
 */
public class Cook extends java.util.Observable  implements Observer  {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }


    @Override
    public void update(Observable o, Object arg) {
//Order order=(Order) arg;
        ConsoleHelper.writeMessage("Start cooking - ");
        setChanged();
        notifyObservers(arg);
    }
}
