package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 05.03.2017.
 */
public  class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
void run() throws InterruptedException {
    for (int i = 0; i <100 ; i++) {
        move();
        print();
        Thread.sleep(200);
    }
}
    void print(){
        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    }
    void move(){
        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).move();
        }
    }

    public Horse getWinner(){
        double maxdistance=horses.get(0).getDistance();
        Horse winner =horses.get(0);
        for (int i = 1; i <horses.size() ; i++) {
             double currentdistance = horses.get(i).getDistance();
            if(currentdistance>maxdistance){
                maxdistance =currentdistance;
                winner=horses.get(i);
            }
        }


        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+ getWinner().getName()+"!");
    }


    public static void main(String[] args) throws InterruptedException {
Horse aaa=new Horse("aaa",3,0);
        Horse bbb=new Horse("bbb",3,0);
        Horse ccc=new Horse("ccc",3,0);
        List<Horse> ddd = new ArrayList<>();
         game =new Hippodrome(ddd);
        game.getHorses().add(aaa);
        game.getHorses().add(bbb);
        game.getHorses().add(ccc);

game.run();
        game.printWinner();
    }
}
