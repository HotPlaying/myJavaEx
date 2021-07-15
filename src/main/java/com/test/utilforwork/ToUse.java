package com.test.utilforwork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author tangrd
 * @date 2020/9/22 10:14
 * @description
 */
public class ToUse {
    public static void main(String[] args) {
        while (true) {
            Text textList = new Text(new ArrayList<>());
            System.out.println("输入要转换的字符串：");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                StringBuilder text = new StringBuilder(scanner.nextLine());
                if ("".equals(text.toString())) break;      // 输入空行，则结束输入
                if ("exit".equals(text.toString())) return; // 输入中的一行为"exit"则退出程序
                textList.textList.add(text.toString());
            }
            OutputUtil.outToLog(textList.toLower());
        }
    }

}
