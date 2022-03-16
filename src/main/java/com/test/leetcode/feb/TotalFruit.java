package com.test.leetcode.feb;

import org.junit.Test;

/**
 * @author trd
 * @since 2022/2/28 17:48
 * https://leetcode-cn.com/problems/fruit-into-baskets/
 */
public class TotalFruit {
    @Test
    public void test() {
        System.out.println("执行结果：");
        System.out.println(totalFruit1(new int[]{1, 2, 1}));
        System.out.println(totalFruit1(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit1(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit1(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));

        System.out.println("预期结果");
        System.out.println("3");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
    }

    /**
     * 暴力解法
     */
    public int totalFruit(int[] fruits) {
        if (fruits.length == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 0; i < fruits.length - 1; i++) {
            int t1 = fruits[i];
            int t2 = -1;
            int s1 = 0, s2 = 0;
            int j = i;
            for (; j < fruits.length; j++) {
                if (t1 == fruits[j]) continue;
                t2 = fruits[j];
                break;
            }
            for (int k = i; k < fruits.length; k++) {
                int f = fruits[k];
                if (f == t1) s1++;
                else if (f == t2) s2++;
                else break;
                int tt = s1 + s2;
                if (tt > res) res = tt;
            }
        }

        return res;

    }

    /**
     * 滑动窗口
     */
    public int totalFruit1(int[] fruits) {
        int res = 1;
        int i = 0, j = 0;

        int a = fruits[0], b = -1;
        int bs = 0;

        int subLength;
//        {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}
        while (j < fruits.length) {
            final int t = fruits[j];

            if (t != a && b == -1) {
                b = t;
                bs = j;
            } else if (t != a && t != b) {
                i = bs;
                a = b;
                b = t;
                bs = j;
            }

            subLength = j - i + 1;
            res = Math.max(subLength, res);

            j++;
        }

        return res;

    }

    public int totalFruit2(int[] fruits) {
        int n = fruits.length;

        if (n <= 2) return n;

        int ans = 2, left = 0, right = 0;
        // 计算篮中每种水果出现的次数。 因为提示中说明了水果的种类数是有限的 0 <= fruits[i] < fruits.length
        int[] freq = new int[n];
        int count = 0;

        while (right < n) {
            freq[fruits[right]]++;

            if (freq[fruits[right]] == 1) {
                count++;
            }

            right++;
            while (count > 2) {
                freq[fruits[left]]--;
                if (freq[fruits[left]] == 0) {
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
