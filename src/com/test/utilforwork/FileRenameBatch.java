package com.test.utilforwork;

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
    public static void main(String[] args) {

        /**
         * D:\Video\Animation\_字幕\[异域-11番小队]零之使魔3三美姬的轮舞Zero_no_Tsukaima_Princesse_no_Rondoi][HKG]
         * D:\Video\Animation\[VCB-Studio] Zero no Tsukaima\[VCB-Studio] Zero no Tsukaima Princess no Rondo [Ma10p_1080p]\SPs
         * 1
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字幕文件目录路径：");
        String dstPath = scanner.nextLine();
        System.out.println(dstPath);
        System.out.println("输入视频文件目录路径：");
        String srcPath = scanner.nextLine();
        System.out.println(srcPath);
        System.out.println("请选择：1.验证，2.真正改名");
        String option = scanner.nextLine();

        File dst = new File(dstPath);
        File src = new File(srcPath);
        assert dst.isDirectory();
        assert src.isDirectory();
        List<String> srcFileList = Arrays.asList(src.list());
        List<String> dstFileList = Arrays.asList(dst.list());

        int i = 0;

        for (String s : srcFileList) {
            if (!s.matches(".*SP.*\\.mkv")) continue;
            else {
                while (!dstFileList.get(i).matches(".*SP.*")) i++;
                String fileNewName = s.split("\\.")[0] + ".ass";
//                String n = i < 10 ? "0" + i : Integer.toString(i);
                File item = new File(dst.getPath() + "\\" + dstFileList.get(i++));
                File item_new = new File(dst.getPath() + "\\" + fileNewName);

                if ("1".equals(option)) {
                    System.out.printf("\"%s\" renameTo \"%s\" \n", item.getName(), item_new.getName());
                } else if ("2".equals(option)) {
                    System.out.printf("\"%s\" renameTo \"%s\" is [%s]\n", item.getName(), item_new.getName(), item.renameTo(item_new));
                } else {
                    System.out.println("无效选项");
                }
            }
        }
//        String dstName = "\\[VCB-Studio] Zero no Tsukaima [#i#][Ma10p_1080p][x265_flac].ass";

//        int i = 0;
//        for (String s : dstFileList) {
//            if (s.matches(".*\\.ass")) {
//                String n = i < 10 ? "0" + i : Integer.toString(i);
//                i++;
//                String item_newName = dstName.replaceAll("#i#", n);
//                File item = new File(dst.getPath() + "\\" + s);
//                File item_new = new File(dst.getPath() + item_newName);
//                System.out.println("[" + item.getName() + "] renameTo [" + item_new.getName() + "] is [" + item.renameTo(item_new) + "]");
//            }
//        }
    }

}
