package com.mb.testdemo.java;

/**
 *  Thread 的 run方法和start方法的区别
 */
public class Test1 {

    static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i=0; i<10;i++){
                System.out.println("run"+i);
            }
        }
    }

    public static void main (String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.start();
//        myThread.run();
        for (int i=0; i<10; i++){
            System.out.println("main"+i);
        }
    }
}
