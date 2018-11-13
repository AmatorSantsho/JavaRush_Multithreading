package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by 123 on 30.09.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    @Override
    public String toString() {
       if (dishes.isEmpty())
           return "";
        else{
           StringBuilder stringBuilder=new StringBuilder();

           for (int i=0;i<dishes.size();i++){
               stringBuilder.append(dishes.get(i));
               if (i==dishes.size()-1)
                   break;
               stringBuilder.append(",");
           }
           return "Your order: ["+stringBuilder.toString()+
                   "] of "+
                   tablet+", cooking time "+getTotalCookingTime()+"min";
       }


    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes= ConsoleHelper.getAllDishesForOrder();
       //System.out.println(this);
    }

    public int getTotalCookingTime(){
        int result=0;
        for (int i = 0; i < dishes.size(); i++) {
            result=result+dishes.get(i).getDuration();
        }
        return result;
    }
    public boolean isEmpty(){
        if (dishes.isEmpty())
            return true;
        else return false;
    }
}
