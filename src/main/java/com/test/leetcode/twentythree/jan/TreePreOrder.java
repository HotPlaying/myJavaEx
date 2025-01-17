package com.test.leetcode.twentythree.jan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TreePreOrder {
  @Test
  public void test() {
//    System.out.println(preorderTraversal(buildTree()));
    System.out.println(midOrderTraversal(buildTree()));
  }

  public TreeNode buildTree() {
    TreeNode root = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);
    return root;
  }


  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode p = stack.pop();
      ans.add(p.val);
      if (p.right != null) {
        stack.push(p.right);
      }
      if (p.left != null) {
        stack.push(p.left);
      }
    }
    return ans;
  }

  public List<Integer> midOrderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
      if (p != null) {
        stack.push(p);
        p = p.left;
      } else {
        p = stack.pop();
        ans.add(p.val);
        p = p.right;
      }
    }
    return ans;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
