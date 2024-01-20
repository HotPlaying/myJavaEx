package com.test.utilforwork.filerename;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
  * @author tangrd 
  * @since 2023/9/3 2:11
  */
public class SubFileRenameTest {
  @Test
  public void test() {
    Constants.step = 1;
    Constants.DEFAULT_SUB_TYPE = "ass";
    SubFileRename.subFileRenameBatch(
      "F:\\Video\\Animation\\Blu-ray Disc\\[VCB-Studio] NISEKOI\\[VCB-Studio] NISEKOI [Ma10p_1080p]",
      "F:\\Video\\Animation\\_字幕\\新建文件夹",
      "2"
    );
  }

  @Test
  public void listAndCompare() {
    final File local = new File("F:\\Video\\Animation\\Blu-ray Disc");
    final String[] localList = local.list();
    final File movable = new File("H:\\Media\\Video\\Animation\\Blu-ray Disc");
    final List<String> movableList = Arrays.stream(movable.list()).toList();
    final List<String> list1 = Stream.of(localList).filter(v -> movableList.contains(v)).toList();
    for (String s : list1) {
      System.out.println(s);
    }
  }
}
