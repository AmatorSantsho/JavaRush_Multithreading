package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 123 on 17.04.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public  static void writeMessage(String message){
        System.out.println(message);

    }
    public static String readString() {
        String result;
        while (true) {
            try {
                result = bufferedReader.readLine();
                break;
            } catch (IOException e) {
                writeMessage("��������� ������ ��� ������� ����� ������. ���������� ��� ���.");
            }
        }
        return result;
    }
    public  static int readInt(){
        int k = 0;
        try {
            k = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("��������� ������ ��� ������� ����� �����. ���������� ��� ���");
            try {
                k = Integer.parseInt(readString());
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            }
        }
        return k;
    }
}
