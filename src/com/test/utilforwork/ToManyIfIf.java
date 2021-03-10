/*
 * @Author: tangrd
 * @Date: 2020-07-15 16:58:14
 * @Description:
 */
package com.test.utilforwork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import static com.test.utilforwork.ConstCollection.bridList;
import static com.test.utilforwork.ConstCollection.trList;

/**
 * @author tangrd
 * @date 2020/5/27 16:16
 * @updatetime 2020-07-15 16:58:14  在vscode测试
 * @destination 解决一堆if和if的重复性代码，要打40几条，太麻烦，故
 * 写出了这么一个工具，来自动生成对应属性对应代码
 */
public class ToManyIfIf {
    public static final String FILE_TYPE = ".txt";

    public static void main(String[] args) throws IOException {

        while (true) {
            List<String> textList = new ArrayList<>();
            System.out.println("输入要转换的字符串：");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                StringBuilder text = new StringBuilder(scanner.nextLine());
                if ("".equals(text.toString())) break;      // 输入空行，则结束输入
                if ("exit".equals(text.toString())) return; // 输入中的一行为"exit"则退出程序
                textList.add(text.toString());
            }
//            System.out.println(joinDouhao(textList));
//        printHiddenValue(textList);
//            scanner.close();
//            printUpper(textList);
        printLower(textList);
//            printDICITEM(textList);
//            outputAddHidden(textList, file);
//            outputUpper(textList, file);
//            outputDicItemSort(textList, file);
//            outputTable(textList, file);
        }
    }

    public static void outputDicItemSort(List<String> textList, File file) {
        String s1 = "";
        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (String s : textList) {
            if (!s1.equals(s)) {
                s1 = s;
                i = 1;
            }
            sb.append(Integer.toString(i++) + '\n');
        }
        outputToFile(file, sb);
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
    public static void printAddHidden(List<String> textList) {
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

    /**
     * @Author tangrd
     * @Description 添加隐藏输入框，用于传值到后台，写入到文件中
     * 测试好以后写这种重复性的代码就方便多了，直接在文件里面拿出来
     * @Date 2020/7/27 17:49
     **/
    public static void outputAddHidden(List<String> textList, File file) {
        StringBuilder sb = new StringBuilder();
        for (String s : textList)
            sb.append("let ").append(s).append(" = $.CurrentNavtab.find('#").append(s).append("').val();\n");
        sb.append("$.CurrentNavtab.find(\"#dm_bl_ztx_form\").append(`\n");
        for (String s : textList)
            sb.append("<input type=\"hidden\" id=\"").append(s).append("\" name=\"").append(s).append("\" value=\"` + ").append(s).append(" + `\">\n");
        sb.append("`);\n");
        for (String s : textList) {
            sb.append("$.CurrentNavtab.find(\"#").append(s).append("\").attr('readonly', true);\n");
        }
        outputToFile(file, sb);
    }

    public static void outputUpper(List<String> textList, File file) {
        StringBuilder sb = new StringBuilder();
        for (String s : textList) {
//            System.out.println("'" + s.toUpperCase() + "',");
//            sb.append("'" + s.toUpperCase() + "',");
//            System.out.println(s.toLowerCase());
            sb.append(s.toUpperCase()).append('\n');
        }
        outputToFile(file, sb);
    }

    /**
     * 表格拆分窗格
     * @Date 2020/8/26 14:58
     **/
    public static void outputTable(List<String> textList, File file) {
//        StringBuilder sb = new StringBuilder();
        String regex = "\\.<tr>\\.";
        int i = 0;
        for (String s : textList) {
            StringBuilder sb = new StringBuilder();
            sb.append(s).append("\n");
            if (regex.matches(s)) {
                sb.append(trList[i++]).append("\n");
            }
            outputToFile(file, sb);
        }
        System.out.println("输出完成，文件路径：" + file.getPath());
//        outputToFile(file, sb);
    }
    /**
     * 输出到文件
     * @Date 2020/8/26 14:49
     **/
    public static void outputToFile(File file, StringBuilder sb) {
        try {
            byte[] bytes = sb.toString().getBytes();    // 前面组的stringBuilder转换为比特流
            Files.write(file.toPath(), bytes);          // 将比特流写入到文件中

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void printSetDefaultValue(List<String> textList) {
        for (String s : textList) {
            System.out.println("if (o.get" + s + "() == null ||\"\".equals(o.get" + s + "()))\n" +
                    "            o.set" + s + "(\"0\");");
            System.out.println("var " + s + " = $.CurrentNavtab.find('#" + s + "').val();");
        }
    }

    public static String setIntoUpperCase(StringBuilder text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
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
            System.out.println("'" + s.toUpperCase() + "',");
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


