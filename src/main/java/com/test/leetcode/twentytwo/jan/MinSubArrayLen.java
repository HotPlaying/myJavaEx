package com.test.leetcode.twentytwo.jan;

import org.junit.Test;

/**
 * @author trd
 * @since 2022/2/18 14:34
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {
    @Test
    public void test() {
        System.out.println("执行结果：");
        System.out.println(minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen1(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen1(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen1(11, new int[]{1, 2, 3, 4, 5}));

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

    public int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        // 始指针
        int i = 0;
        // 尾指针
        int j = 0;
        // 滑动窗口长度
        int sumLength = 0;
        // 滑动窗口值和
        int sum = 0;

        while (j < nums.length) {
            sum += nums[j];

            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= target) {
                sumLength = j - i + 1;
                res = Math.min(res, sumLength);
                // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
                sum -= nums[i++];
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}