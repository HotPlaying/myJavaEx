package com.test.leetcode.dec;

import org.junit.Test;

/**
 * @author tangrd
 * @since 2021/12/11 1:38
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {
    @Test
    public void test() {
        System.out.println("执行结果:");
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(2147395599));

        System.out.println("预期结果:");
        System.out.println((int)Math.pow(4, 0.5));
        System.out.println((int)Math.pow(8, 0.5));
        System.out.println((int)Math.pow(5, 0.5));
        System.out.println((int)Math.pow(9, 0.5));
        System.out.println((int)Math.pow(2147395599, 0.5));
    }


    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            long tar = (long) mid * mid;
            if (tar < x) {
                l = mid + 1;
            } else if (tar > x) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return r;
    }
}
