package com.test.leetcode.twentythree.jan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 1.循环整个s
 * 遇到左括号就入栈，否则出栈
 * 检查出栈的这个和遍历到的这个字符是否配对
 * 2. 循环
 * 碰到左括号就往栈推入一个配对的右括号
 * 碰到右括号就从栈取出一个看是否与碰到的相等
 */
public class ValidKuohao {
  public boolean isValid(String s) {
    Deque<Character> deque = new ArrayDeque<>();
    final List<String> l = List.of("(", "[", "{");
    final List<String> r = List.of(")", "]", "}");
    for (char c : s.toCharArray()) {
      if (l.contains(c)) {
        deque.push(c);
      } else {
//        deque
      }
    }
    return false;
  }

  @ValueSource(strings = {"abbaca"})
  @ParameterizedTest
  void test(String input) {
    System.out.println(removeDuplicates(input));
  }

  // 删除字符串中的所有相邻重复项
  /**
   * 遍历字符串
   * 取出栈末尾的元素，与遍历到的元素比较
   * 若不等，则遍历到的元素入栈，否则出栈一个元素
   * 最后返回栈中剩余元素
   */
  public String removeDuplicates(String s) {
    Deque<Character> deque = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (deque.isEmpty() || c != deque.getLast()) {
        deque.push(c);
      } else {
        deque.pop();
      }
    }

    return String.copyValueOf(deque.toArray(), 0, deque.size() - 1);
  }
}
