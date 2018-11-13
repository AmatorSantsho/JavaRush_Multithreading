package com.javarush.task.task25.task2508;

public class TaskManipulator  implements Runnable,CustomThreadManipulator {
  private Thread t;


    @Override




    public void run() {

        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void start(String threadName) {
 t=new Thread(this);
        t.setName(threadName);
        t.start();
    }

    @Override
    public void stop() {
t.interrupt();
    }
}
