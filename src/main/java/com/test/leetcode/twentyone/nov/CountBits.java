package com.test.leetcode.twentyone.nov;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author trd
 * @since 2021/11/25 17:13
 * https://leetcode-cn.com/problems/w3tCBm/
 */
public class CountBits {
    public int[] s1(int n) {
        int len = n + 1;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 31; j >= 0; j--) {
                int bi = i >>> j & 1;
                if (1 == bi) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(s1(2)));
        System.out.println("[0, 1, 1]");
        System.out.println(Arrays.toString(s1(5)));
        System.out.println("[0, 1, 1, 2, 1, 2]");
        binaryToDecimal(20);
    }

    public void binaryToDecimal(int n) {

        for (int i = 31; i >= 0; i--) {
            Object a = n >>> i & 1;
            System.out.print(a);
        }
    }
}
