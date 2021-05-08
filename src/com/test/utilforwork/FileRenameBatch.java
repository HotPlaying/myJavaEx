package com.test.utilforwork;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author tangrd
 * @date 2021/3/7 0:19
 * @description
 */
public class FileRenameBatch {
    public static String subtitleFile_type = "ass";
    public static int step = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字幕文件目录路径：");
        String dstPath = scanner.nextLine();
        System.out.println(dstPath);
        System.out.println("输入视频文件目录路径：");
        String srcPath = scanner.nextLine();
        System.out.println(srcPath);
        System.out.println("请选择：1.验证，2.真正改名");
        String option = scanner.nextLine();

        step = 1;
        fileRenameBatch(srcPath, dstPath, option);
        if (!"1".equals(option)) return;


        System.out.println("是否真正改名：1.是，2.否");
        option = scanner.nextLine();
        if (!"1".equals(option)) return;

        step = 2;
        fileRenameBatch(srcPath, dstPath, option);
    }

    private static void fileRenameBatch(String srcPath, String dstPath, String option) {
        File dst = new File(dstPath);
        File src = new File(srcPath);
        assert dst.isDirectory();
        assert src.isDirectory();
        List<String> srcFileList = Arrays.asList(src.list());
        List<String> dstFileList = Arrays.asList(dst.list());
        int i = 0;
        boolean res = true;
        for (String s : srcFileList) {
            if (!s.matches(".*\\.mkv")) continue;
            while (!dstFileList.get(i).matches(".*\\." + subtitleFile_type)) i++;

            String fileNewName = s.substring(0, s.lastIndexOf('.')) + "." + subtitleFile_type;
//                String n = i < 10 ? "0" + i : Integer.toString(i);
            File item = new File(dst.getPath() + "\\" + dstFileList.get(i++));
            File item_new = new File(dst.getPath() + "\\" + fileNewName);


            if (step == 1) {
                switch (option) {
                    case "1":
                        System.out.printf("\"%s\" renameTo \"%s\" \n", item.getName(), item_new.getName());
                        break;
                    case "2":
                        System.out.printf("\"%s\" renameTo \"%s\" is [%s]\n", item.getName(), item_new.getName(), item.renameTo(item_new));
                        break;
                }
            }
            if (step == 2) {
                switch (option) {
                    case "1":
                        res = res && item.renameTo(item_new);
                        System.out.print(res ? "-" : "|");
                        break;
                    case "2":
                        break;
                }
            }
        }
        if (2 == step && "1".equals(option)) {
            System.out.println("\n批量重命名" + (res ? "成功" : "失败"));
        }
    }

    @Test
    public void test() {
        File file = new File("F:\\DEV Files\\Tomcat\\apache-tomcat-8.5.64\\webapps\\comics\\我立于百万生命之上");
        String[] fileList = file.list();
        for (String s : fileList) {
            if (s.matches(".*\\.html")) {
                System.out.println(s);

            }
        }
    }
}
