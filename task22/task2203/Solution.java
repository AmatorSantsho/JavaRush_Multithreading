package com.javarush.task.task22.task2203;

/* 
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String res="";
        try {
            int a=  string.indexOf("\t");
            System.out.println(a);
            int b = string.indexOf("\t", a+1);
            System.out.println(b);
            res=string.substring(a+1,b);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return res;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
