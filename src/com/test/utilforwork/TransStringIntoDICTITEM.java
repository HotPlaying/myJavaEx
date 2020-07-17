package com.test.utilforwork;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author tangrd
 * @date 2020/5/26 11:52
 */
public class TransStringIntoDICTITEM {
    public static void main(String[] args) {
        while (true) {
            System.out.println("输入要转换的字符串：");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.next();
            List<String> nameList = Arrays.asList(s1.split("/"));
            for (String s : nameList) {
                System.out.println(s);
            }

            for (int i = 1; i <= nameList.size(); i++) {
                System.out.println(i);
            }
        }
    }
}
