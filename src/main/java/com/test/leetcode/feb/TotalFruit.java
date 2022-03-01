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
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));

        System.out.println("预期结果");
        System.out.println("3");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
    }

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
            for (int k = i; k < fruits.length; k++ ) {
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
}
