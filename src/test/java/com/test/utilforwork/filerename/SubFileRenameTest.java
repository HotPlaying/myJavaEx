package com.test.utilforwork.filerename;

import org.junit.Test;

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
}