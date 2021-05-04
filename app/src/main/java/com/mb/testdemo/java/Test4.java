package com.mb.testdemo.java;

/**
 *  synchronized 对象锁和类锁
 */
public class Test4 {
    public static void main (String[] args){
//        syncSameObject();
//        syncDiffObject();
        syncStaticDiffObject();
    }

    //对象锁 同一个对象加锁有效
    static void syncSameObject(){
        final SyncObject test1 = new SyncObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.getCount();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.getCount();
            }
        }).start();
    }

    //对象锁 不同对象加锁无效
    static void syncDiffObject(){
        final SyncObject test1 = new SyncObject();
        final SyncObject test2 = new SyncObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.getCount();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.getCount();
            }
        }).start();
    }

    //类锁 所有这个类的对象锁都有效
    static void syncStaticDiffObject(){
        final StaticSyncObject test1 = new StaticSyncObject();
        final StaticSyncObject test2 = new StaticSyncObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.getCount();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.getCount();
            }
        }).start();
    }
}
