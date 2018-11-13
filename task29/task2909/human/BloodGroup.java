package com.javarush.task.task29.task2909.human;

/**
 * Created by 123 on 14.04.2017.
 */
public class BloodGroup {
    private final int code;

    public int getCode() {
        return code;
    }

    private BloodGroup(int code) {
        this.code = code;
    }
   public static BloodGroup first(){
       BloodGroup bloodGroup = new BloodGroup(1);
       return bloodGroup;
   }
    public static BloodGroup second(){
        BloodGroup bloodGroup = new BloodGroup(2);
        return bloodGroup;
    }
    public static BloodGroup third(){
        BloodGroup bloodGroup = new BloodGroup(3);
        return bloodGroup;
    }
    public static BloodGroup fourth(){
        BloodGroup bloodGroup = new BloodGroup(4);
        return bloodGroup;
    }
}
