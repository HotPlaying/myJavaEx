package com.test.utilforwork;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author tangrd
 * @date 2021/3/7 0:19
 * @description
 */
public class FileRenameBatch {
    public static String subtitleFile_type = "ssa";
    public static int step = 0;

    public static int times = 100;

    private static void fileRenameBatch(String srcPath, String dstPath, String option) {
        File dst = new File(dstPath);
        File src = new File(srcPath);
        assert dst.isDirectory();
        assert src.isDirectory();
        String[] srcFileList = src.list();
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

    private static void fileRenameBatchOnce(String dstPath, String option) {
        File dst = new File(dstPath);

        assert dst.isDirectory();

        String[] dstFileList = dst.list();

        boolean res = true;

        for (String s : dstFileList) {
//            System.out.println(s);
            if (!s.matches("\\d+_.*")) continue;

            String[] splits = s.split("_");

            String fileNewName = s.split("_")[1];
            File item = new File(dst.getPath() + File.separator + s);
            File item_new = new File(dst.getPath() + File.separator + fileNewName);

            switch (option) {
                case "1":
                    System.out.println(s);
                    break;
                case "2":
                    if (s.length() < 40)
                        System.out.printf("【%-39s\t】->【%s】 \n", item.getName(), item_new.getName());
                    break;
                case "3":
                    res = res && item.renameTo(item_new);
                    System.out.print(res ? "-" : "|");
                    if (res) break;

                    int index = 1;
                    while (!res) {
                        res = true;
                        String[] nameSplit = fileNewName.split("\\.");
                        if (nameSplit.length < 2) break;
                        String repeatFileName = nameSplit[nameSplit.length - 2] +
                                "(" + index++ + ")" + "." +
                                nameSplit[nameSplit.length - 1];
                        item_new = new File(dst.getPath() + File.separator + repeatFileName);
                        res = res && item.renameTo(item_new);
                        System.out.printf("\n[%s] repeated! set into [%s]: [%s]\n", fileNewName, repeatFileName, res);
                        fileNewName = repeatFileName;
                    }
//                    System.out.printf("\"%s\" renameTo \"%s\" is [%s]\n", item.getName(),
//                    item_new.getName(), item.renameTo(item_new));
                    break;
            }
        }
        if ("3".equals(option)) {
            System.out.println("\n批量重命名" + (res ? "成功" : "失败"));
        }
    }

    /**
     * 批量按照动画BD视频文件名来重命名字幕文件 - 流程
     */
    public static void videoSubtitleFileRename() {
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

    public static void main(String[] args) throws InterruptedException {
        try {
            mainProcess(args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000L);
        }
    }

    private static void mainProcess(String[] args) {
        if (args.length > 0) {
            subtitleFile_type = Optional.ofNullable(args[0]).orElse(subtitleFile_type);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("选择操作：1.动画BD字幕重命名，2.音乐文件重命名");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                videoSubtitleFileRename();
                break;
            case "2":
                numMusicFileRename();
        }
    }

    /**
     * 音乐重命名去掉数字前缀 - 流程
     */
//    @Test
    public static void numMusicFileRename() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入音乐文件目录路径：");
        String dstPath = scanner.nextLine();
        System.out.println(dstPath);
        while (true) {
            System.out.println("请选择：1.列出符合条件的文件，2.预览改名，3.真正改名，q.退出");
            String option = scanner.nextLine();
            if ("q".equals(option)) return;
            fileRenameBatchOnce(dstPath, option);
        }

    }

    @Test
    public void test() throws InterruptedException {
        String filePath = "D:\\WorkSpace\\ProjectsSrc\\macau-power-api\\WebRoot\\WEB-INF\\lib";
        File file = new File(filePath);
        String[] fileList = file.list();
        for (String s : fileList) {
            System.out.println(s);
        }
        Thread.sleep(1000L);
    }
}
