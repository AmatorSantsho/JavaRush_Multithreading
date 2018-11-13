package com.javarush.task.task22.task2211;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке .
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);


        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte []b = new byte[fileInputStream.available()];
        fileInputStream.read(b);


        String s =new String(b,"UTF-8");
        b = s.getBytes("Windows-1251");
        fileOutputStream.write(b);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
