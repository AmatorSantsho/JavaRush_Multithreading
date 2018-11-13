package com.javarush.task.task29.task2909.car;

/**
 * Created by 123 on 14.04.2017.
 */
public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
