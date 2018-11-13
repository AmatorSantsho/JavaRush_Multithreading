package com.javarush.task.task25.task2506;

/**
 * Created by 123 on 10.04.2017.
 */
public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run()    {
        State state = thread.getState ( );
        System.out.println (state);
        while (state != State.TERMINATED)
        {
            if (state != thread.getState ( ))
            {
                state = thread.getState ( );
                System.out.println (state);
            }
        }


    }

}
