package com.test.leetcode.twentytwo.sep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangrd
 * @since 2022/9/15 20:24
 */
public class WordPattern {
    @Test
    public void test() {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
        pattern = "aaaa"; s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
        pattern = "abba"; s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
        pattern = "abba"; s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        if (null == pattern || null == s) {
            return false;
        }
        String[] sList = s.split(" ");
        char[] chars = pattern.toCharArray();

        if (chars.length != sList.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char p = chars[i];
            String word = sList[i];
            if (map.containsKey(p)) {
                String s1 = map.get(p);
                if (!s1.equals(word)) {
                    return false;
                }
            } else if (map.containsValue(word)) {
                return false;
            } else {
                map.put(p, word);
            }
        }
        return true;
    }
}
