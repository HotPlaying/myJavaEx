package com.test.leetcode.twentyone.nov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangrd
 * @since 2021/11/24 22:43
 * https://leetcode-cn.com/problems/Ygoe9J/
 */
public class Ygoe9J {
    @Test
    public void test() {
        int[] can = {2, 3, 6, 7};
        int target = 7;
        System.out.println(s1(can, target));
    }

    public List<List<Integer>> s1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        dfs(candidates, target, ans, com, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> com, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(com));
            return;
        }

        // 直接跳过
        dfs(candidates, target, ans, com, idx + 1);

        // 选择当前数
        int current = candidates[idx];
        if (target - current >= 0) {
            com.add(current);
            dfs(candidates, target - current, ans, com, idx);
            com.remove(com.size() - 1);
        }
    }
}
