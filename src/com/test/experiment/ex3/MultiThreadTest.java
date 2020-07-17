package com.test.experiment.ex3;

import java.util.concurrent.locks.StampedLock;

public class MultiThreadTest {
    private final StampedLock stampedLock = new StampedLock();
    public void test() {
        Counter counter = new Counter();
        counter.equals(new Counter());
    }
}
