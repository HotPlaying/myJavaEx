package com.test.experiment.ex.ex7;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ConcurrentLinkedQueueTest {
  @Test
  public void test() {
    Queue<Integer> integers = new ConcurrentLinkedQueue<>();
    integers.add(1);
    integers.add(3);
    integers.add(4);
    integers.add(5);
    System.out.println(integers);
    while (!integers.isEmpty()) {
      System.out.println(integers.poll());
    }

    System.out.println(integers);
  }
}
