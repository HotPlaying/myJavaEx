package com.test.experiment.threadtest;

/**
 * @author tangrd
 * @date 2021/5/8 9:43
 * @description
 */
public class DefaultCounter {
    private int num;

    DefaultCounter(){
        num = 0;
    }

    public void add() {
        num ++;
//        System.out.printf("%s = %d", , c1.get());
    }

    public int get() {
        return num;
    }
}
