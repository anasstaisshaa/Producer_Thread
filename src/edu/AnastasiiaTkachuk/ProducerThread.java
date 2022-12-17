package edu.AnastasiiaTkachuk;

import java.util.Queue;

public class ProducerThread implements Runnable{

    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list){
            while(true){
                int random = MyRandom.getRandom();
                System.out.println("produces adds value: " + random);
                list.add(random);
                try {
                    int randomWaitValue = MyRandom.getRandom();
                    System.out.println("producer waits: " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
