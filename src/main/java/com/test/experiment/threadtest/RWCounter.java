package com.test.experiment.threadtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tangrd
 * @date 2021/5/8 10:38
 * @description
 */
public class RWCounter {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private  int num;

    public RWCounter() {
        num = 0;
    }

    public void add() {
        writeLock.lock();
        try {
            num++;
        } finally {
            writeLock.unlock();
        }
    }

    public int get() {
        readLock.lock();
        try {
            return num;
        } finally {
            readLock.unlock();
        }
    }


}
