package com.test.experiment.threadtest;

/**
 * @author tangrd
 * @date 2021/5/8 11:22
 * @description
 */
public class Counter {
    protected int NUM;

    public Counter(){
        NUM = 0;
    }

    void add() {
        NUM++;
    }

    int get() {
        return NUM;
    }
}
