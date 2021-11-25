package com.test.leetcode.nov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangrd
 * @since 2021/11/25 21:57
 * https://leetcode-cn.com/problems/4sjJUc/
 */
public class CombinationSum2 {
    @Test
    public void test() {
        int[] can1 = {10, 1, 2, 7, 6, 1, 5};
        int[] can = {10, 7, 6, 5, 2, 1, 1};
        int target = 8;
        String ans = "[\n" +
                "[1,1,6],\n" +
                "[1,2,5],\n" +
                "[1,7],\n" +
                "[2,6]\n" +
                "]";
        System.out.println(s1(can, target));
        System.out.println(ans);
    }

    public List<List<Integer>> s1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, target, ans, com, 0, len);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> com, int idx, int n) {
        if (target == 0) {
            ans.add(new ArrayList<>(com));
            return;
        }

        for (int i = idx; i < n; i++) {
            int current = candidates[i];
            if (current > target) {
                break;
            }

            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            com.add(current);
            dfs(candidates, target - current, ans, com, i + 1, n);
            com.remove(com.size() - 1);
        }
    }
}
