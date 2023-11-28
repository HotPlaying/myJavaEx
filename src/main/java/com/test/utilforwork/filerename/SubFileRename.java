package com.test.utilforwork.filerename;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static com.test.utilforwork.filerename.Constants.*;

/**
 * @author tangrd
 * @since 2023/9/3 1:02
 */
public class SubFileRename {
  /**
   * 批量按照动画BD视频文件名来重命名字幕文件 - 流程
   */
  public static void videoSubtitleFileRename() {
    Scanner scanner = new Scanner(System.in);
    logger("输入字幕文件目录路径：");
    String subPath = scanner.nextLine();
    logger(subPath);
    logger("输入视频文件目录路径：");
    String videoPath = scanner.nextLine();
    logger(videoPath);
    logger("请选择：1.验证，2.真正改名");
    String option = scanner.nextLine();

    step = 1;
    subFileRenameBatch(videoPath, subPath, option);
    if (!"1".equals(option)) return;


    logger("是否真正改名：1.是，2.否");
    option = scanner.nextLine();
    if (!"1".equals(option)) return;

    step = 2;
    subFileRenameBatch(videoPath, subPath, option);
  }

  private static List<String> fileList(String path) {
    File dst = new File(path);
    assert dst.isDirectory();
    return Arrays.asList(Objects.requireNonNull(dst.list()));
  }


  public static void subFileRenameBatch(String videoPath, String subPath, String option) {
    File subDirectory = new File(subPath);
    final List<String> subFileList = fileList(subPath).stream().filter(SubFileRename::validSubFileName).toList();
    final List<String> videoFileList = fileList(videoPath).stream()
      .filter(SubFileRename::validVideoFileName)
      .limit(subFileList.size()).toList();

    AtomicBoolean renameResult = new AtomicBoolean(true);
    AtomicInteger index = new AtomicInteger();
    videoFileList.forEach(videoFileName -> {
      File srcSub = new File(subDirectory.getPath() + "\\" + subFileList.get(index.getAndIncrement()));
      File dstSub = new File(subDirectory.getPath() + "\\" + newSubNameFrom(videoNameFrom(videoFileName)));
      if (step == 1) {
        switch (option) {
          case "1" -> logger("\"%s\" renameTo \"%s\" \n", srcSub.getName(), dstSub.getName());
          case "2" ->
            logger("\"%s\" ➡ \"%s\" [%s]\n", srcSub.getName(), dstSub.getName(), srcSub.renameTo(dstSub) ? "√" : "×");
        }
      }
      if (step == 2) {
        switch (option) {
          case "1" -> {
            renameResult.set(renameResult.get() && srcSub.renameTo(dstSub));
            System.out.print(renameResult.get() ? "-" : "|");
          }
          case "2" -> {
          }
        }
      }
    });

    if (2 == step && "1".equals(option)) {
      logger("\n批量重命名" + (renameResult.get() ? "成功" : "失败"));
    }
  }

  private static boolean validVideoFileName(String srcVideoFileName) {
    return srcVideoFileName.matches(".*\\.mkv");
  }

  private static String newSubNameFrom(String videoName) {
    return videoName + "." + DEFAULT_SUB_TYPE;
  }

  private static String videoNameFrom(String videoFileName) {
    return videoFileName.substring(0, videoFileName.lastIndexOf('.'));
  }

  private static boolean validSubFileName(String subFileName) {
    return subFileName.matches(".*\\." + DEFAULT_SUB_TYPE);
  }


}
