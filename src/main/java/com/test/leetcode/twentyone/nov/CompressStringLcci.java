package com.test.leetcode.twentyone.nov;

import org.junit.Test;

/**
 * @author trd
 * @since 2021/11/24 16:25
 * https://leetcode-cn.com/problems/compress-string-lcci/
 */
public class CompressStringLcci {
    public String s1(String s) {
        char[] src = s.toCharArray();
        int srcLen = s.length();

        if (srcLen <= 1) {
            return s;
        }

        char[] dst = new char[srcLen];
        int dstP = 0;
        int dstLen = 0;
        int totalCount = 0;
        for (int srcP = 0; srcP < srcLen && dstP < srcLen; ) {
            totalCount++;
            dst[dstP++] = src[srcP];
            int singleCharCount = 0;
            for (int j = srcP; j < srcLen; j++) {
                if (src[srcP] != src[j]) {
                    break;
                }
                singleCharCount++;
            }
            if (dstP >= srcLen) {
                break;
            }
            srcP += singleCharCount;
            if (singleCharCount < 10) {
                dst[dstP++] = Integer.toString(singleCharCount).toCharArray()[0];
                dstLen += 2;
            } else if (singleCharCount < 100) {
                char[] ca = Integer.toString(singleCharCount).toCharArray();
                dst[dstP++] = ca[0];
                dst[dstP++] = ca[1];
                dstLen += 3;
            } else if (singleCharCount < 1000) {
                char[] ca = Integer.toString(singleCharCount).toCharArray();
                dst[dstP++] = ca[0];
                dst[dstP++] = ca[1];
                dst[dstP++] = ca[2];
                dstLen += 4;
            } else if (singleCharCount < 10000) {
                char[] ca = Integer.toString(singleCharCount).toCharArray();
                dst[dstP++] = ca[0];
                dst[dstP++] = ca[1];
                dst[dstP++] = ca[2];
                dst[dstP++] = ca[3];

                dstLen += 5;
            }
        }
        // 用原数组的条件 (字符数 * 2 >= 原数组长度)
        if (totalCount * 2 >= srcLen) {
            dst = src;
        } else {
            srcLen = dstLen;
        }
        return String.copyValueOf(dst, 0, srcLen);
    }

    @Test
    public void test() {
        System.out.println(s1("aabcccccaaa"));
        // "a2b1c5a3"
        System.out.println(s1("abbccd"));
        // "abbccd"
        System.out.println(s1("bbbac"));
        // bbbac
        System.out.println(s1("a"));
        // a
        System.out.println(s1("rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff"));
        System.out.println("r5L5P6R5g3N5V10D10I10l7A4q7b3N4f6");
        // "r5L5P6R5g3N5V10D10I10l7A4q7b3N4f6"
    }
}
