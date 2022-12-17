package edu.AnastasiiaTkachuk;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Thread producerThread = new Thread(new ProducerThread(queue));
        Thread producerThread1 = new Thread(new ProducerThread(queue));
        Thread consumerThread = new Thread(new ConsumerThread(queue));

        producerThread.start();
        producerThread1.start();
        consumerThread.start();

        producerThread.join();
        producerThread1.join();
        consumerThread.join();
    }
}
