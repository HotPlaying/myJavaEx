package com.test.experiment.interview.yifangda.threethread;

import java.util.concurrent.Semaphore;

/**
 * @author tangrd
 * @since 2022/9/11 23:11
 */
public class UseSemaphore {
    public static void main(String[] args) {
        final Semaphore A = new Semaphore(1);
        final Semaphore B = new Semaphore(0);
        final Semaphore C = new Semaphore(0);

        new MyThread("A", A, B).start();
        new MyThread("B", B, C).start();
        new MyThread("C", C, A).start();
    }

    private static class MyThread extends Thread {
        private final String s;
        private final Semaphore self;
        private final Semaphore next;

        public MyThread(String s, Semaphore self, Semaphore next) {
            this.s = s;
            this.self = self;
            this.next = next;
        }
        @Override
        public void run() {
            try {
                for (int i = 0; i < ThreeThreadConst.TIMES; i++) {
                    self.acquire();
                    System.out.println(s);
                    next.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
