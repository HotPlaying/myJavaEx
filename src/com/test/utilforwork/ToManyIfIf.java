/*
 * @Author: tangrd
 * @Date: 2020-07-15 16:58:14
 * @Description:
 */
package com.test.utilforwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author tangrd
 * @date 2020/5/27 16:16
 * @updatetime 2020-07-15 16:58:14  在vscode测试
 * @destination 解决一堆if和if的重复性代码，要打40几条，太麻烦，故
 * 写出了这么一个工具，来自动生成对应属性对应代码
 */
public class ToManyIfIf {
    public static String[] bridList = {"472fe429a37d48599241696178c284be",
            "485cd9511063464e9a5c85cdb0b0dbc3",
            "2787e8bb589140f5a5993c347d65293c",
            "f4c17735a91c4812a8b26a6e1d03c1c7",
            "d6520bf0e40d4f31b4824ca2ffd929b3",
            "fe023422bf374312950b126db4533f13",
            "67b65e33d5de410891452dba277cc9af",
            "98188ea63d6c4a7f9f148833b0727ac6",
            "e80475accd754590a933adf2a95ff7f9",
            "e92633f6e57e431c8eba79a00045a684"};

//    public static

    public static void main(String[] args) {
        while (true) {
            List<String> textList = new ArrayList<>();
            System.out.println("输入要转换的字符串：");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                StringBuilder text = new StringBuilder(scanner.nextLine());
                if ("".equals(text.toString()))
                    break;
                textList.add(text.toString());
            }
//            System.out.println(joinDouhao(textList));
//        printHiddenValue(textList);
//            scanner.close();
        printUpper(textList);
//        printLower(textList);
//            printDICITEM(textList);
        }
    }

    public static void printDICITEM(List<String> textList) {
        List<Integer> counter = new ArrayList<>();
        for (String s1 : textList) {
            int i = 1;
            String[] nameList = s1.split("/");
            for (String s : nameList) {
                System.out.println(s);
                counter.add(i++);
            }
        }
        System.out.println();
        for (Integer i : counter) {
            System.out.println(i);
        }
        int b = -1;
        for (Integer i : counter) {
            if (i == 1) {
                b++;
            }
            System.out.println(bridList[b]);
        }
    }

    /*
    添加隐藏输入框，用于传值到后台
        */
    public static void addHidden(List<String> textList) {
        for (String s : textList)
            System.out.println("let " + s + " = $.CurrentNavtab.find('#" + s + "').val();");
        System.out.println("$.CurrentNavtab.find(\"#dm_bl_ztx_form\").append(`");
        for (String s : textList)
            System.out.println("<input type=\"hidden\" id=\"" + s + "\" name=\"" + s + "\" value=\"` + " + s + " + `\">");
        System.out.println("`);");
        for (String s : textList) {
//                System.out.println("setHiddenValue(\"" + s + "\", resMap." + s + ");");
            System.out.println("$.CurrentNavtab.find(\"#" + s + "\").attr('readonly', true);");
        }
    }

    public static void setDefaultValue(List<String> textList) {
        for (String s : textList) {
            System.out.println("if (o.get" + s + "() == null ||\"\".equals(o.get" + s + "()))\n" +
                    "            o.set" + s + "(\"0\");");
            System.out.println("var " + s + " = $.CurrentNavtab.find('#" + s + "').val();");
        }
    }

    public static StringBuilder setIntoUpperCase(StringBuilder text) {
        return new StringBuilder().append(Character.toUpperCase(text.charAt(0))).append(text.substring(1));
    }

    public static String joinDouhao(List<String> textList) {
        StringJoiner sj = new StringJoiner(",");
        for (String s : textList) {
            sj.add(s);
        }
        return sj.toString();
    }

    /*
    String cla = getRequest().getParameter("cla_1");
    o.setCla(cla);
     */
    public static void printHiddenValue(List<String> textList) {
        for (String s : textList) {
            System.out.println("String " + s + " = request.getParameter(\"" + s + "_1\");");
        }
        for (String s : textList) {
            System.out.println("o.set" + Character.toUpperCase(s.charAt(0)) + s.substring(1) + "(" + s + ");");
        }
    }

    public static void printUpper(List<String> textList) {
        for (String s : textList) {
            System.out.println("'"+s.toUpperCase()+"',");
//            System.out.println(s.toLowerCase());
        }
    }

    public static void printLower(List<String> textList) {
        for (String s : textList) {
//            System.out.println(s.toUpperCase());
            System.out.println(s.toLowerCase());
        }
    }
}


