package edu.AnastasiiaTkachuk;

import java.util.Queue;

public class ConsumerThread implements Runnable{
    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if(!list.isEmpty()){
                    Integer removeValue = list.remove();
                    System.out.println("consumer get value: " + removeValue);
                } else{
                    System.out.println("list is empty, consumer waiting");
                }
                try {
                    int random = MyRandom.getRandom();
                    System.out.println("consumer wait: " + random);
                    list.wait(random);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
