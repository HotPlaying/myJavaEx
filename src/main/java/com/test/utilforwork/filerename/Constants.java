package com.test.utilforwork.filerename;

/**
 * @author tangrd
 * @since 2023/9/3 1:03
 */
public class Constants {
  public static String DEFAULT_SUB_TYPE = "ssa";
  public static String DEFAULT_VIDEO_TYPE = "mkv";
  public static int step = 0;

  public static void logger(String format, Object ... args) {
    System.out.printf(format, args);
  }

  public static void logger(String format) {
    System.out.println(format);
  }
}
