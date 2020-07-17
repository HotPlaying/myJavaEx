package com.test.experiment.ex5;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        System.out.println("输入要转换的字符串：");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.next();
            List<String> nameList = Arrays.asList(s1.split("；"));
            for (String s : nameList) {
                System.out.println(s);
            }

            for (int i = 1; i <= nameList.size(); i++) {
                System.out.println(i);
            }
        }
    }
}
