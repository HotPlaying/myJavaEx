package com.test.leetcode.dec;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author trd
 * @since 2021/12/7 17:11
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {
    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums1 = {};
        System.out.println("执行结果：");
        System.out.println(ss(nums, 8));
        System.out.println(ss(nums, 7));
        System.out.println(ss(nums, 6));
        System.out.println(ss(nums, 10));
        System.out.println(ss(nums1, 0));

        System.out.println("预期结果：");
        System.out.println("[3, 4]");
        System.out.println("[1, 2]");
        System.out.println("[-1, -1]");
        System.out.println("[5, 5]");
        System.out.println("[-1, -1]");
    }

    public String ss(int[] nums, int target) {
        return Arrays.toString(searchRange(nums, target));
    }
    public int[] searchRange(int[] nums, int target) {

    }
}
