package com.test.utilforwork.transien;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author tangrd
 * @since 2022/9/19 21:10
 */
public class GetSubtitlesFromRarbgTest {

  @Test
  public void test() throws IOException {
//        String source = "F:\\Video\\Animation\\Cyberpunk.Edgerunners.S01.JAPANESE.1080p.WEBRip.x265-RARBG";
//        String source = "F:\\Video\\Animation\\DOTA.Dragons.Blood.S01.1080p.WEBRip.x265-RARBG";
//        String source = "F:\\Video\\Animation\\DOTA.Dragons.Blood.S02.1080p.WEBRip.x265-RARBG";
//        String source = "F:\\Video\\Animation\\DOTA.Dragons.Blood.S03.1080p.WEBRip.x265-RARBG";
    String source = "F:\\Video\\TV\\Upload.S01.1080p.WEBRip.x265-RARBG";
    String srcDir = source + "\\Subs";
    String dstDir = source + "\\nnsc";
    File srcFile = new File(srcDir);
    String[] srcFileList = srcFile.list();

    File dstFile = new File(dstDir);
    if (dstFile.exists() && dstFile.isDirectory()) dstFile.mkdir();

    String subNameContains = "26_C";
    for (String subParentDirName : srcFileList) {
      String subParentDir = srcDir + File.separator + subParentDirName;
      String[] subFileNames = new File(subParentDir).list();
      String srcSubFileName = Arrays.stream(subFileNames).filter(sub -> sub.contains(subNameContains)).findFirst().orElse(null);
      if (null == srcSubFileName) continue;
      final File srcSubFile = new File(subParentDir + File.separator + srcSubFileName);
      final File dstSubFile = new File(dstDir + File.separator + subParentDirName + ".srt");
      FileUtils.copyFile(srcSubFile, dstSubFile);
    }
    for (String s : srcFileList) {
      System.out.println(s);
    }
    System.out.println("-Complete.");
  }
}
