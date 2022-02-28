package com.test.leetcode.jan;

import org.junit.Test;

/**
 * @author trd
 * @since 2022/2/18 14:34
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("执行结果：");
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));

        System.out.println("预期结果：");
        System.out.println("2");
        System.out.println("1");
        System.out.println("0");
        System.out.println("3");
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = 0;


        for (int i = 0; i < nums.length; i++) {
            int all = 0;
            for (int j = i; j < nums.length; j++) {
                all += nums[j];
                if (all < target) {
                    continue;
                }
                final int dist = j - i + 1;
                if (res == 0 || dist < res) {
                    res = dist;
                }
                break;

            }
        }
        return res;
    }
}