package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University  {

    private String name;
    private int age;
    private List<Student> students =new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public University() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade( double grade) {
        Student student;
        for (int i = 0; i < students.size(); i++) {
            student=students.get(i);
            if(student.getAverageGrade()==grade)
                return student;

        }





        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        int n = 0;

        double maxAverageGrade = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = student.getAverageGrade();
                n = i;
            }

        }
        return students.get(n);

    }
    public Student getStudentWithMinAverageGrade() {
        int n = 0;

        double minAverageGrade = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getAverageGrade() < minAverageGrade) {
                minAverageGrade = student.getAverageGrade();
                n = i;
            }

        }
        return students.get(n);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}