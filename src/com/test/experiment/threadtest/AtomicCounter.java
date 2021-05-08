package com.test.experiment.threadtest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangrd
 * @date 2021/5/8 11:21
 * @description
 */
public class AtomicCounter implements Counter {
//    private static final sun.misc.Unsafe U;
//
//    static {
//        try {
//            U =sun.misc.Unsafe.getUnsafe();
//        } catch (Exception e) {
//            throw new Error(e);
//        }
//    }

//    public static final AtomicInteger ai = new AtomicInteger();
    private volatile AtomicInteger NUM;

    public AtomicCounter() {
        NUM = new AtomicInteger(0);
    }

    @Override
    public void add() {
        NUM.getAndIncrement();
//        NUM.compareAndSet(NUM.get(), NUM.get + 1);
    }

    @Override
    public int get() {
        return NUM.get();
    }
}
