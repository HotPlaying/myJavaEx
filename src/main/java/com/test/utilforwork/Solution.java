package com.test.utilforwork;

/**
 * @author tangrd
 * @since 2022/10/17 21:27
 */
public class Solution {
    public static int minOperations(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] <= nums[i]) {
                nums[i + 1] = nums[i + 1] + (nums[i] - nums[i + 1] + 1);
                ans += nums[i] - nums[i + 1] + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 4, 1};
        System.out.println(minOperations(nums));
    }
}
