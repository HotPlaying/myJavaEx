package com.test.experiment.threadtest;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockMultiCounter {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private int[] counts = new int[10];

    public void add(int index) {
        writeLock.lock();
        try {
            counts[index]++;
        } finally {
            writeLock.unlock();
        }
    }

    public int[] get() {
        readLock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            readLock.unlock();
        }
    }
}
