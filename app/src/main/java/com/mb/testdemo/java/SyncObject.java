package com.mb.testdemo.java;

public class SyncObject {
    private int count = 10;
    public void getCount() {
        synchronized(this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
