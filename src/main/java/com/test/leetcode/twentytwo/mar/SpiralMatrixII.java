package com.test.leetcode.twentytwo.mar;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author trd
 * @since 2022/3/15 16:39
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {
    @Test
    public void test() {
        System.out.println("执行结果：");
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(4)));
        System.out.println("预期结果：");
        System.out.println("[[1]]");
        System.out.println("[[1,2,3],[8,9,4],[7,6,5]]");
        System.out.println("[[1, 2, 3, 4],[12, 13, 14, 5],[11, 16, 15, 6],[10, 9, 8, 7]]");
    }

    @Test
    public void test1() {
        int a = 4;
        System.out.println((a + (a >> 1)));
    }

    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];
        int next = n - 1;
        int round = 0;
        int j = 0;
        int fx = 1;

        for (int i = 1; i <= n * n; i++) {


            if (j >= next) {
                j = 0;
                fx++;
            }

            if (fx > 4) {
                fx = 1;
                round++;
                next -= 2;
            }

            if (1 == fx) {
                ans[round][j + round] = i;
            }

            if (2 == fx) {
                ans[j + round][n - 1 - round] = i;
            }

            if (3 == fx) {
                ans[n - 1 - round][n - 1 - round - j] = i;
            }

            if (4 == fx) {
                ans[n - 1 - round - j][round] = i;
            }

            j++;
        }

        return ans;
    }
}
