package com.test.experiment.interview.yifangda.singleton;

/**
 * @author trd
 * @since 2022/9/19 16:57
 * 饿汉式
 */
public class SingletonEHS {
    private static SingletonEHS instance = new SingletonEHS();

    private SingletonEHS() {}

    public static SingletonEHS getInstance() {
        return instance;
    }
}
