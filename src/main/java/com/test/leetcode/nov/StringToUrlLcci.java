package com.test.leetcode.nov;

import org.junit.Test;

/**
 * @author trd
 * @since 2021/11/23 15:44
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 */
public class StringToUrlLcci {
    public String solution(String s, int length) {
        int slen = s.length();
        int kgs = (slen - length) / 2;

//        for (int i = 0; i < length; i++) {
//            char charAt = s.charAt(i);
//            if (charAt == ' ') {
//
//            }
//        }

        char[] ans = new char[slen];
        int i = 0, j = 0;
        while (j < length) {
            char charAt = s.charAt(j);
            if (charAt == ' ' && kgs > 0) {
                ans[i] = '%';
                ans[i + 1] = '2';
                ans[i + 2] = '0';
                kgs--;
                i += 3;
            } else {
                ans[i] = charAt;
                i++;
            }
            j++;
        }

        return String.valueOf(ans,0, i);
    }

    @Test
    public void test() {
        String s = solution("ds sdfs afs sdfa dfssf asdf             ",
                27);
        System.out.println(s);
    }
}
