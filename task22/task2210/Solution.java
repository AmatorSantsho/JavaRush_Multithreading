package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args) {

    }


        public static String[] getTokens (String query, String delimiter){
            StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
            List<String> words = new ArrayList<>();
            while (stringTokenizer.hasMoreTokens())
                words.add(stringTokenizer.nextToken());
            String[] stringArray = new String[words.size()];
            for (int i = 0; i < stringArray.length; i++)
                stringArray[i] = words.get(i);
            return stringArray;
        }
    }
