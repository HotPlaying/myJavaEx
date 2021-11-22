package com.test.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tangrd
 * @since 2021/11/23 0:07
 * https://leetcode-cn.com/problems/is-unique-lcci/
 */
public class IsUniqueLcci {
    public boolean solution1(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public boolean solution2(String astr) {
        char[] as = astr.toCharArray();
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

        for (int i = 0; i < len - 1; i++) {
            if (as[i] == as[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean solution3(String astr) {
        int len = astr.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
