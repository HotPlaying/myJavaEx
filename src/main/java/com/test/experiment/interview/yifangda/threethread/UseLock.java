package com.test.experiment.interview.yifangda.threethread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangrd
 * @since 2022/9/11 22:30
 */
public class UseLock {
    final static Lock lock = new ReentrantLock();
    // 通过state的值来确定是哪个线程打印
    static int state = 0;
    public static void main(String[] args) {
        char startChar = 'A';
        for (int i = 0; i < ThreeThreadConst.THREAD_COUNT; i++) {
            new MyThread((char) (startChar + i), i).start();
        }
    }
    private static class MyThread extends Thread {
        private final char printContent;
        private final int index;
        public MyThread(char printContent, int index) {
            this.printContent = printContent;
            this.index = index;
        }
        @Override
        public void run() {
            for (int i = 0; i < ThreeThreadConst.TIMES; ) {
                // 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                while (state % ThreeThreadConst.THREAD_COUNT != index) ;
                try {
                    lock.lock();
                    System.out.println(printContent);
                    state++;
                } finally {
                    i++;
                    lock.unlock();
                }
            }
        }
    }
}
