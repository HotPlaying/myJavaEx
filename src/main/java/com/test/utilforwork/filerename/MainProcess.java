package com.test.utilforwork.filerename;

import java.util.Optional;
import java.util.Scanner;

import static com.test.utilforwork.filerename.Constants.*;
import static com.test.utilforwork.filerename.NumMusicFileRename.numMusicFileRename;
import static com.test.utilforwork.filerename.SubFileRename.videoSubtitleFileRename;

/**
 * @author tangrd
 * @since 2023/9/3 0:57
 */
public class MainProcess {
  public static void main(String[] args) throws InterruptedException {
    try {
      mainProcess(args);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      Thread.sleep(10000L);
    }
  }

  private static void mainProcess(String[] args) {
    if (args.length > 0) {
      Optional.of(args).map(a -> a[0]).ifPresent(v -> DEFAULT_SUB_TYPE = v);
      Optional.of(args).filter(a -> a.length >= 2).map(a -> a[1]).ifPresent(v -> DEFAULT_VIDEO_TYPE = v);
    }
    Scanner scanner = new Scanner(System.in);
    logger("选择操作：1.动画BD字幕重命名，2.音乐文件重命名");
    String option = scanner.nextLine();
    switch (option) {
      case "1" -> videoSubtitleFileRename();
      case "2" -> numMusicFileRename();
    }
  }
}
