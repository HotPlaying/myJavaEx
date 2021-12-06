package com.test.leetcode.dec;

/**
 * @author tangrd
 * @since 2021/12/5 17:06
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {

    /**
     * {1,3,5,6} 5 2
     * {1,3,5,6} 2 3
     * {1,3,5,6} 7 4
     * {1,3,5,6} 0 5
     */

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (target > nums[r]) {
            return r + 1;
        }
        if (target < nums[l]) {
            return l;
        }

        while (l <= r) {
            if (r - l == 1) {
                return r;
            }
            int mid = l + ((r - l) >>> 1);
            int a = nums[mid];
            if (target > a) {
                l = mid + 1;
            } else if (target < a) {
                r = mid - 1;
            }
        }
        return -1;
    }
}
