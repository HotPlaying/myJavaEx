package com.test.leetcode.twentytwo.mar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author trd
 * @since 2022/3/17 10:33
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    @Test
    public void test() {
        System.out.println("执行结果：");
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
//        System.out.println(spiralOrder(4));
        System.out.println("预期结果：");
//        System.out.println("[[1]]");
        System.out.println("[1,2,3,6,9,8,7,4,5]");
        System.out.println("[1,2,3,4,8,12,11,10,9,5,6,7]");
    }

    public List<Integer> spiralOrder(int[][] matrix) {

//        int[][] matrix = new int[n][n];
        int m = matrix.length;
        int n = matrix[0].length;
        int nNext = n - 1;
        int mNext = m - 1;
        int round = 0;
        int j = 0;
        int fx = 1;

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n * m; i++) {
            int dst = 0;

            if (fx % 2 != 0 && j >= nNext) {
                j = 0;
                fx++;
            }
            if (fx % 2 == 0 && j >= mNext) {
                j = 0;
                fx++;
            }
            if (fx > 4) {
                fx = 1;
                round++;
                nNext -= 2;
                mNext -= 2;
            }
            if (1 == fx) {
                dst = matrix[round][j + round];
            }
            if (2 == fx) {
                dst = matrix[j + round][m - 1 - round];
            }
            if (3 == fx) {
                dst = matrix[n - 1 - round][m - 1 - round - j];
            }
            if (4 == fx) {
                dst = matrix[n - 1 - round - j][round];
            }
            j++;
            ans.add(dst);
        }

        return ans;
    }
}
