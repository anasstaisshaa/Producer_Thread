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
                if(list.size() < 10){
                    int random = MyRandom.getRandom();
                    list.add(random);
                    list.notifyAll();
                    System.out.println("produces adds value: " + random + ". Size" + list.size());

                } else {
                    System.out.println("producer does nothing");
                }
                list.notifyAll();
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
