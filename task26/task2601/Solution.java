package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double mediana;
        if ((array.length % 2) == 0)
        {
            mediana = ( array[array.length / 2] +array[array.length / 2 - 1] )/ 2;
        }
        else
        {
            mediana = array[array.length / 2];
        }


        int k=(array.length+1)/2;
final int med = (int)mediana;
        Comparator c =new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Math.abs((int)o1-med))-Math.abs(((int)o2-med));
            }
        };
        Arrays.sort(array,c);

        return array;
    }
}
