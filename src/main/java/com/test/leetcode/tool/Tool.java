package com.test.leetcode.tool;

import com.test.leetcode.dec.BinarySearch;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.function.Consumer;

/**
 * @author trd
 * @since 2021/12/6 17:58
 */
public class Tool {
    Consumer<Tool.Answer> FUN = (answer -> {
        System.out.println("预期结果：");
        System.out.println(answer.trueAns);
        System.out.println("执行结果：");
//        System.out.println(search2(answer.arr, answer.target));
    });

    @Builder
    @AllArgsConstructor
    public static class Answer {
        int[] arr;
        int target;
        int trueAns;

        public void run() {

        }
    }
}
