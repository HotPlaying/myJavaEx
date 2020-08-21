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
    public static final String FILE_TYPE = ".txt";

    public static void main(String[] args) throws IOException {
        String datetime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss").format(LocalDateTime.now());
        String path = "F:\\Log\\export_" + datetime.toString() + FILE_TYPE;
        System.out.println(path);
        File file = new File(path);
        boolean createSuccess = file.createNewFile();
        while (createSuccess) {
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
//        printLower(textList);
//            printDICITEM(textList);
//            outputAddHidden(textList, file);
//            outputUpper(textList, file);
            outputDicItemSort(textList,file);
        }
    }

    public static void outputDicItemSort(List<String> textList, File file) {
        String s1 = "";
        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (String s: textList) {
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

    public static void outputToFile(File file, StringBuilder sb) {
        try {
            byte[] bytes = sb.toString().getBytes();    // 前面组的stringBuilder转换为比特流
            Files.write(file.toPath(), bytes);          // 将比特流写入到文件中
            System.out.println("输出完成，文件路径：" + file.getPath());
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


