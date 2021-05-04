package com.mb.testdemo.java;

/**
 *  Thread 的状态测试
 */
public class Test3 {


    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());
            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        System.out.println(t.getState());
        t.start();
        try {
            // 保证线程执行完再执行下面代码
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
