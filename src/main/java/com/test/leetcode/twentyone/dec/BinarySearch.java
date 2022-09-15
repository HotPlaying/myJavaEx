package com.test.leetcode.twentyone.dec;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author tangrd
 * @since 2021/12/5 1:41
 * https://leetcode-cn.com/problems/binary-search/
 */
public class BinarySearch {
    Consumer<Answer> FUN = (answer -> {
        System.out.println("预期结果：");
        System.out.println(answer.trueAns);
        System.out.println("执行结果：");
        System.out.println(search2(answer.arr, answer.target));
    });

    @Test
    public void test() {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        FUN.accept(new Answer(arr, 9, 4));
        int[] arr1 = {5};
        FUN.accept(new Answer(arr1, 5, 0));
        int[] arr2 = {-1, 0, 3, 5, 9, 12};
        FUN.accept(new Answer(arr2, 2, -1));
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int l, int r) {
        int mid = (r + l) / 2;
        int a = nums[mid];
        if (r < l) {
            return -1;
        }
        if (target > a) {
            return search(nums, target, mid + 1, r);
        } else if (target < a) {
            return search(nums, target, l, mid - 1);
        }
        return mid;
    }

    public int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (r >= l) {
            int mid = l + ((r - l) >>> 1);
            int a = nums[mid];
            if (target > a) {
                l = mid + 1;
            } else if (target < a) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Builder
    @AllArgsConstructor
    public static class Answer {
        int[] arr;
        int target;
        int trueAns;
    }
}
