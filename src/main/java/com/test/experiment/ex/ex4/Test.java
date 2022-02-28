package com.test.experiment.ex.ex4;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        int target = start;
        for (int i : list) {
            if (i != target)
                return target;
            target++;
        }
        return 0;
    }


}
