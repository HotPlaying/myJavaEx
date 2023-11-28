package com.test.utilforwork.filerename;

import java.io.File;
import java.util.Scanner;

/**
 * @author tangrd
 * @since 2023/9/3 2:22
 */
public class NumMusicFileRename {

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

  private static void fileRenameBatchOnce(String dstPath, String option) {
    File dst = new File(dstPath);

    assert dst.isDirectory();

    String[] dstFileList = dst.list();

    boolean res = true;

    for (String s : dstFileList) {
      if (!s.matches("\\d+_.*")) continue;

      String[] splits = s.split("_");

      String fileNewName = s.split("_")[1];
      File item = new File(dst.getPath() + File.separator + s);
      File item_new = new File(dst.getPath() + File.separator + fileNewName);

      switch (option) {
        case "1" -> System.out.println(s);
        case "2" -> {
          if (s.length() < 40)
            System.out.printf("【%-39s\t】->【%s】 \n", item.getName(), item_new.getName());
        }
        case "3" -> {
          res = res && item.renameTo(item_new);
          System.out.print(res ? "-" : "|");
          if (res) break;
          int index = 1;
          while (!res) {
            res = true;
            String[] nameSplit = fileNewName.split("\\.");
            if (nameSplit.length < 2) break;
            String repeatFileName = nameSplit[nameSplit.length - 2] + "(" + index++ + ")" + "." + nameSplit[nameSplit.length - 1];
            item_new = new File(dst.getPath() + File.separator + repeatFileName);
            res = res && item.renameTo(item_new);
            System.out.printf("\n[%s] repeated! set into [%s]: [%s]\n", fileNewName, repeatFileName, res);
            fileNewName = repeatFileName;
          }
        }
      }
    }
    if ("3".equals(option)) {
      System.out.println("\n批量重命名" + (res ? "成功" : "失败"));
    }
  }

}
