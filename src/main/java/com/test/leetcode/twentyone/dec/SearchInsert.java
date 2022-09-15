package com.test.leetcode.twentyone.dec;

import org.junit.Test;

import com.test.leetcode.tool.Question;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author tangrd
 * @since 2021/12/5 17:06
 * https://leetcode-cn.com/problems/search-insert-position/
 */
@AllArgsConstructor
public class SearchInsert extends Question {

    public Params params;

    @Override
    public Object run() {
        return run(params.nums, params.target);
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 5, 6};
        System.out.println("执行结果：");
        System.out.println(searchInsert1(arr, 5));
        System.out.println(searchInsert1(arr, 2));
        System.out.println(searchInsert1(arr, 7));
        System.out.println(searchInsert1(arr, 1));
        System.out.println(searchInsert1(arr, 3));
        System.out.println(searchInsert1(arr, 4));
        System.out.println("预期结果：");
        System.out.println(2);
        System.out.println(1);
        System.out.println(4);
        System.out.println(0);
        System.out.println(1);
        System.out.println(2);

    }


    /**
     * {1,3,5,6} 5 2
     * {1,3,5,6} 2 3
     * {1,3,5,6} 7 4
     * {1,3,5,6} 0 0
     */

    @AllArgsConstructor
    @NoArgsConstructor
    public static class Params extends Question.Params {
        int[] nums;
        int target;
    }

    public static int run(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            int a = nums[mid];
            if (target > a) {
                l = mid + 1;
            } else if (target < a) {
                r = mid - 1;
            }
            if (target == a) {
                return mid;
            }
        }
        return r + 1;
    }
}
