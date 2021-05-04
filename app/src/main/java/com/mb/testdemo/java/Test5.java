package com.mb.testdemo.java;

/**
 *  同步和非同步方法是否可以同时调用？ （同步和非同步的方法可以同时调用）
 */
public class Test5 {

    public synchronized void syncFunc() {
        System.out.println(Thread.currentThread().getName() + " syncFunc start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " syncFunc end");
    }

    public void asyncFunc() {
        System.out.println(Thread.currentThread().getName() + " asyncFunc start...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " asyncFunc end... ");
    }

    public static void main(String[] args) {
        final Test5 test = new Test5();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用对象的同步方法
                test.syncFunc();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用对象的异步方法
                test.asyncFunc();
            }
        }).start();

    }
}
