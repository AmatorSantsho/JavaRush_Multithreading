package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 30.09.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {


        return bufferedReader.readLine();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Enter plase a Dish from a list(for end enter exit))");
        String input = null;
        while (!(input = readString()).equals("exit")) {
            boolean contens=false;
            for (Dish d : Dish.values()) {

                if (d.name().equals(input)) {
                    list.add(Dish.valueOf(input));
                    contens=true;
                    break;
                }


            }
            if (!contens)writeMessage("Dish is not avalibal.Try again");
        }
        return list;
    }
}