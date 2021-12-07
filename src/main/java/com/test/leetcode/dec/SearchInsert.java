package com.test.leetcode.dec;

import org.junit.Test;

/**
 * @author tangrd
 * @since 2021/12/5 17:06
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {
    @Test
    public void test() {
        int[] arr = {1, 3, 5, 6};
        System.out.println("执行结果：");
        System.out.println(searchInsert(arr, 5));
        System.out.println(searchInsert(arr, 2));
        System.out.println(searchInsert(arr, 7));
        System.out.println(searchInsert(arr, 1));
        System.out.println(searchInsert(arr, 3));
        System.out.println(searchInsert(arr, 4));
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

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int s2HS(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (target > nums[r]) {
                return r + 1;
            }
            if (target < nums[l]) {
                return l;
            }
            int mid = l + ((r - l) >>> 1);
            int a = nums[mid];
            if (target > a) {
                l = mid + 1;
            } else if (target < a) {
                r = mid - 1;
            } if (target == a) {
                return mid;
            }
        }
        return l + 1;
    }
}
