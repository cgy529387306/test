package com.mb.testdemo.java;

import java.util.ArrayList;
import java.util.List;

// synchronized可以保证可见性和原子性，volatile只能保证可见性
public class Test9 {
    volatile int count = 0;
    int syncCount = 0;

    void funcVolatile() {
        for(int i=0; i<10000; i++) count++;
        System.out.println(Thread.currentThread().getName());
    }

    synchronized void funcSync() {
        for(int i=0; i<10000; i++) syncCount++;
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        testVolatile();
//        testSync();
    }


    static void testVolatile() {
        final Test9 test = new Test9();

        List<Thread> threads = new ArrayList<Thread>();

        for(int i=0; i<10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.funcVolatile();
                }
            },"thread-" + i);
            threads.add(thread);
        }

        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(test.count);
    }

    static void testSync() {
        final Test9 test = new Test9();

        List<Thread> threads = new ArrayList<Thread>();

        for(int i=0; i<10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.funcSync();
                }
            },"thread-" + i);
            threads.add(thread);
        }

        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(test.syncCount);
    }
}
