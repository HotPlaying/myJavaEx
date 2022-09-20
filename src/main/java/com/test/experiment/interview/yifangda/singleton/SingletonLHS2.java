package com.test.experiment.interview.yifangda.singleton;

/**
 * @author tangrd
 * @since 2022/9/9 21:48
 * 懒汉式2，支持多线程同步，利用类加载机制实现
 */
public class SingletonLHS2 {
    private static class InstanceHolder {
        private static SingletonLHS2 instance;
    }

    private SingletonLHS2() {}

    public SingletonLHS2 getInstance() {
        return InstanceHolder.instance;
    }
}
