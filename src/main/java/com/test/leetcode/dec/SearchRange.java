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
        System.out.println(ss(new int[]{2, 2}, 3));

        System.out.println("预期结果：");
        System.out.println("[3, 4]");
        System.out.println("[1, 2]");
        System.out.println("[-1, -1]");
        System.out.println("[5, 5]");
        System.out.println("[-1, -1]");
        System.out.println("[-1, -1]");
    }

    public String ss(int[] nums, int target) {
        return Arrays.toString(searchRange(nums, target));
    }

    public int[] searchRange(int[] nums, int target) {
        int r = rightBorder(nums, target);
        int l = leftBorder(nums, target);
        if (l == -2 || r == -2) {
            return new int[]{-1, -1};
        }
        if (r - l > 1) {
            return new int[]{l + 1, r - 1};
        }

        return new int[]{-1, -1};
    }

    public int rightBorder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int rightBorder = -2;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            int a = nums[mid];
            if (target < a) {
                r = mid - 1;
            } else {
                l = mid + 1;
                rightBorder = l;
            }
        }
        return rightBorder;
    }

    public int leftBorder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int leftBorder = -2;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            int a = nums[mid];
            if (target > a) {
                l = mid + 1;
            } else {
                r = mid - 1;
                leftBorder = r;
            }
        }
        return leftBorder;
    }
}
