package com.test.leetcode.twentyone.nov;

/**
 * @author tangrd
 * @since 2021/11/23 0:48
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 */
public class CheckPermutation {
    public boolean solution1(String s1, String s2) {
        s1 = sort(s1);
        s2 = sort(s2);
        return s1.equals(s2);
    }

    String sort(String s) {
        char[] as = s.toCharArray();
        int len = as.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (as[j] < as[j - 1]) {
                    char tmp = as[j];
                    as[j] = as[j - 1];
                    as[j - 1] = tmp;
                }
            }
        }
        return String.copyValueOf(as);
    }
}
