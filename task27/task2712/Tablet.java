package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import javafx.beans.InvalidationListener;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 123 on 30.09.2017.
 */
public class Tablet extends java.util.Observable {
    final int number;
    private static java.util.logging.Logger logger= Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime()*60);
                manager.processVideos();
                setChanged();
                notifyObservers(order);
            }
            return order;

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
            return null;
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
