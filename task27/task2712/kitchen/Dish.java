package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by 123 on 30.09.2017.
 */
public enum Dish {Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
private int duration;

    Dish(int i) {
        this.duration=i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder stringBuilder=new StringBuilder();
        Dish[]dishs=values();
        for (int i=0;i<dishs.length;i++){
            stringBuilder.append(dishs[i].name());
            if (i==dishs.length-1)
                break;
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
