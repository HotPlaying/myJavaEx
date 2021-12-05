package com.test.leetcode.dec;

/**
 * @author tangrd
 * @since 2021/12/5 17:06
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (l == r) {
                return l;
            }
            int mid = l + ((r - l) >>> 1);
            int a = nums[mid];
            if (target > a) {
                l = mid + 1;
            } else if (target < a) {
                r = mid - 1;
            } else {

            }
        }
    }
}
