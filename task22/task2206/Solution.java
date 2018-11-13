package com.javarush.task.task22.task2206;

import java.util.ArrayList;
import java.util.Date;

/* 
Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.

Должен быть вывод аналогичный следующему:
31:10:13 15:59:59
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(124);
        list.add(129);
        list.add(124);
        list.add(127);
        list.add(124);
        list.add(124);
        list.add(124);
        list.add(127);



        StringBuilder text = new StringBuilder();
        for (int i = 0; i <list.size() ; i++) {
            text = text.append((char)(int)list.get(i));
        }
        String s = new String();
        s=text.toString();
        System.out.println(text);
//        Date date = new Date();
//        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
//        //должен быть вывод аналогичный следующему
//        //31:10:13 15:59:59 - dd:MM:yy hh:mm:ss
    }

//    public static String getFormattedString() {
//        return "%td:%tm:%ty %tT";
//    }
}
