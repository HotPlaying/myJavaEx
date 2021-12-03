package com.test.leetcode.dec;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author tangrd
 * @since 2021/12/3 23:14
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {
    @Test
    public void test() {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        run(arr, this::quickSort);
    }

    public int s1(int[] nums) {
        quickSort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public void run(int [] arr, Consumer<int[]> c) {
        System.out.println(Arrays.toString(arr));
        c.accept(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int l, int r) {
        int ol = l, or = r;
        int pivot = nums[l];
        while (l != r) {
            while (r != l && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l != r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        if (l != ol) {
            quickSort(nums, ol, l - 1);
        }
        if (r != or) {
            quickSort(nums, r + 1, or);
        }
    }
}
