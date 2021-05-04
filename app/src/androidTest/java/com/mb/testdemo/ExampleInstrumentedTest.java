package com.mb.testdemo;


import org.junit.Test;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {
  class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i=0; i<10;i++){
                System.out.println("run"+i);
            }
        }
    }

    @Test
    void test1(){
        MyThread myThread = new MyThread();
        myThread.run();
        for (int i=0; i<10; i++){
            System.out.println("main"+i);
        }
    }

}
