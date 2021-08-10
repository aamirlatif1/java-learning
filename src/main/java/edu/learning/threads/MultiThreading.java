package edu.learning.threads;

public class MultiThreading {

    public static final long SLEEP_TIME = 300;

    static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread mt = new MyThread();
        Thread mr = new Thread(new MyRunnable());

        mt.start();
        mr.start();

        while (true) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(SLEEP_TIME);
        }
    }
}
