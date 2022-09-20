package com.test.experiment.interview.yifangda.singleton;

/**
 * @author trd
 * @since 2022/9/19 16:29
 * 懒汉式1，支持多线程同步，利用双检锁
 */
public class SingletonLHS1 {
    private static SingletonLHS1 instance;

    private SingletonLHS1() {}

    public static SingletonLHS1 getInstance() {
        if (instance == null) {
            synchronized (SingletonLHS1.class) {
                if (instance == null) {
                    instance = new SingletonLHS1();
                }
            }
        }
        return instance;
    }


}
