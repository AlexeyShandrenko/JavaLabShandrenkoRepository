package ru.kpfu.itis.pool;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadPool {

    private Deque<Runnable> tasks;

    private PoolWorker[] pool;

    public ThreadPool(int threadsCount) {
        tasks = new ConcurrentLinkedDeque<>();
        pool = new PoolWorker[threadsCount];

        for (int i = 0; i < pool.length; i++) {
            pool[i] = new PoolWorker();
            pool[i].start();
        }

    }

    public void submit(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }

    private class PoolWorker extends Thread {
        @Override
        public void run() {
            Runnable task;
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.poll();
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
    }
}



