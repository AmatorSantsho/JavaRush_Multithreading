package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by 123 on 30.09.2017.
 */
public class Waiter implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg+" was cooked by "+o.toString());
    }
}
