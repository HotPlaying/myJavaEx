package com.test.experiment.interview.yifangda.threethread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangrd
 * @since 2022/9/12 17:01
 */
public class UseAtomicInteger {
    final static AtomicInteger ai = new AtomicInteger(0);

    @Test
    public void testExecutor() {
        ExecutorService a = Executors.newFixedThreadPool(ThreeThreadConst.THREAD_COUNT);
        char s = 'A';
        for (int i = 0; i < ThreeThreadConst.THREAD_COUNT; i++) {
            a.execute(new MyThread((char) (s + i), i));
        }
    }

    public static void main(String[] args) {
        char s = 'A';
        for (int i = 0; i < ThreeThreadConst.THREAD_COUNT; i++) {
            new MyThread((char) (s + i), i).start();
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
            while (ai.get() < ThreeThreadConst.THREAD_COUNT * ThreeThreadConst.TIMES) {
                while (ai.get() % 3 == index) {
                    System.out.println(printContent);
                    ai.getAndIncrement();
                }
            }
        }
    }
}
