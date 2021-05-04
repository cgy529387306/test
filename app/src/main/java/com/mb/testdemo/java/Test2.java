package com.mb.testdemo.java;

/**
 *  Thread sleep,yield，join方法的区别
 */
public class Test2 {
    public static void main (String[] args){
//        testSleep();
//        testYield();
        testJoin();
    }

    static void testSleep(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; i++){
                    System.out.println("A" + i);
                    try {
                        Thread.sleep(500);
                        //TimeUnit.Milliseconds.sleep(500)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; i++){
                    System.out.println("B" + i);
                    try {
                        Thread.sleep(500);
                        //TimeUnit.Milliseconds.sleep(500)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    static void testYield(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    System.out.println("A" + i);
                    if(i%10 == 0) Thread.yield();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    System.out.println("------------B" + i);
                    if(i%10 == 0) Thread.yield();
                }
            }
        }).start();
    }

    static void testJoin(){
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    System.out.println("A" + i);
                    try {
                        Thread.sleep(500);
                        //TimeUnit.Milliseconds.sleep(500)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(int i=0; i<100; i++) {
                    System.out.println("B" + i);
                    try {
                        Thread.sleep(500);
                        //TimeUnit.Milliseconds.sleep(500)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
