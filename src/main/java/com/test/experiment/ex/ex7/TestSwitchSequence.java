package com.test.experiment.ex.ex7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangrd
 * @date 2020/12/20 17:28
 * @description
 */
public class TestSwitchSequence {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c"));
        for(String s : strings) {
            switch (s) {
                case "c":
                    System.out.println("b");
                    break;
                default:
                    System.out.println("default");
                case "a":
                    System.out.println("a");

            }
        }
    }
}
