package com.javarush.task.task22.task2202;

/* 
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
«JavaRush — лучший сервис обучения Java.»

Результат:
«— лучший сервис обучения»

На некорректные данные бросить исключение TooShortStringException (сделать исключением).
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String res= null;
        try {
            String s[]= string.split(" ");
            res = s[1]+" "+s[2]+" "+s[3]+" "+s[4];


        } catch (Exception e) {
            throw new TooShortStringException(e);
        }


        return res;
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(Exception e) {
        }
    }
}
