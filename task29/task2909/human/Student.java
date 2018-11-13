package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;


    public int getCourse() {
        return course;
    }

    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }



    public void live() {
        learn();
    }

    public void learn() {
    }

    @Override
    public String getPosition() {
        return "Студент";
    }


    public void incAverageGrade(double delta){
       setAverageGrade(getAverageGrade()+delta);

    }


   public  void setAverageGrade(double value){
      this.averageGrade = value;
    }
    public  void setCourse(int value){
        this.course = value;
    }


    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}