package com.test.experiment.interview.yifangda.threethread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class UseCountDownLatch {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch startGate = new CountDownLatch(1);
    CountDownLatch endGate = new CountDownLatch(3);

    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(1);

    getThread(startGate, s3, "A", s1, endGate).start();
    getThread(startGate, s1, "B", s2, endGate).start();
    getThread(startGate, s2, "C", s3, endGate).start();

    final long start = System.nanoTime();
    startGate.countDown();
    endGate.await();
    final long end = System.nanoTime();
    System.out.println(end - start);
  }

  private static Thread getThread(CountDownLatch startGate, Semaphore acquire, String s, Semaphore release, CountDownLatch endGate) {
    return new Thread(() -> {
      try {
        startGate.await();
        for (int i = 0; i < 3; i++) {
          acquire.acquire();
          System.out.println(s);
          release.release();
        }
        endGate.countDown();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });
  }

}
