package com.test.leetcode.twentyone.nov;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author trd
 * @since 2021/11/29 17:58
 * https://leetcode-cn.com/problems/WGki4K/
 */
public class SingleNumber {
    @Test
    public void test() {
        int[] a1 = {2, 2, 3, 2};
        int[] a2 = {0, 1, 0, 1, 0, 1, 100};
        int[] a3 = {30000, 500, 100, 30000, 100, 30000, 100};
        System.out.println(solution(a1));
        System.out.println(3);
        System.out.println(solution(a2));
        System.out.println(100);
        System.out.println(solution(a3));
        System.out.println(500);
    }

    public int solution(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        int target = nums[3];
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] != nums[i - 2] && nums[i] != nums[i - 1]) {
                target = nums[i];
                break;
            }
        }
        return target;
    }

    public int s2(int[] nums) {
        int a = 0, b = a;
        for (int num : nums) {
            a = ~b & (a ^ num);
            b = ~a & (b ^ num);
        }
        return a;
    }

}
