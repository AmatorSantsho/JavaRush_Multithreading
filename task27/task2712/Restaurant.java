package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by 123 on 30.09.2017.
 */
public class Restaurant {
    public static void main(String[] args) {
  Tablet tablet=new Tablet(5);
        Cook cook=new Cook("Amigo");
        Waiter waiter=new Waiter();

        tablet.addObserver(cook);
        cook.addObserver(waiter);
        tablet.createOrder();

    }

}
