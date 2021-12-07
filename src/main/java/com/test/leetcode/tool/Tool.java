package com.test.leetcode.tool;

import com.test.leetcode.dec.BinarySearch;
import com.test.leetcode.dec.SearchInsert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author trd
 * @since 2021/12/6 17:58
 */
public class Tool {
    @Test
    public void test1() {
        int[] arr = {1, 3, 5, 6};
        List<Answer> l = new ArrayList<>();
        l.add(Answer.builder().execRes(SearchInsert.run(arr, 5)).trueAns(2).build());
        l.add(Answer.builder().execRes(SearchInsert.run(arr, 2)).trueAns(1).build());
        l.add(Answer.builder().execRes(SearchInsert.run(arr, 7)).trueAns(4).build());
        l.add(Answer.builder().execRes(SearchInsert.run(arr, 0)).trueAns(0).build());
        FUN.accept(l);
    }

    @Test
    public void test2() {
        int[] arr = {1, 3, 5, 6};
        List<Answer> l = new ArrayList<>();
        l.add(Answer.builder().q(new SearchInsert(new SearchInsert.Params(arr, 5))).trueAns(2).build());
        l.add(Answer.builder().q(new SearchInsert(new SearchInsert.Params(arr, 2))).trueAns(1).build());
        l.add(Answer.builder().q(new SearchInsert(new SearchInsert.Params(arr, 7))).trueAns(4).build());
        l.add(Answer.builder().q(new SearchInsert(new SearchInsert.Params(arr, 0))).trueAns(0).build());
        FUN.accept(l);

    }

    public Consumer<List<Answer>> FUN = (l -> {
        System.out.println("执行结果: ");
        for (Answer answer : l) {
            System.out.println(answer.q.run());
        }
        System.out.println("预期结果: ");
        for (Answer answer : l) {
            System.out.println(answer.trueAns);
        }
    });

    @Builder
    @AllArgsConstructor
    public static class Answer {
        Object params;
        Question q;
        //        int[] arr;
        int execRes;
        int trueAns;
    }
}
