package com.test.utilforwork;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangrd
 * @date 2021/3/7 0:19
 * @description
 */
public class FileRenameBatch {
    public static void main(String[] args) {
        File dst = new File("D:\\Video\\Animation\\_字幕\\[异域-11番小队]零之使魔1_Zero_no_Tsukaima[HKG&amp;amp;X2]");
        File src = new File("D:\\Video\\Animation\\[VCB-Studio] Tokyo Ghoul I+II+OVA\\[VCB-Studio] Tokyo Ghoul √A  [Ma10p_1080p]");
        assert dst.isDirectory();
        assert src.isDirectory();
        List<String> srcFileList = Arrays.asList(src.list());
        System.out.println(srcFileList);
        List<String> dstFileList = Arrays.asList(dst.list());
        System.out.println(dstFileList);
        String dstName = "\\[VCB-Studio] Zero no Tsukaima [#i#][Ma10p_1080p][x265_flac].ass";
        int i = 1;
        for (String s : dstFileList) {
            if (s.matches(".*\\.ass")) {
                String n = i < 10 ? "0" + i : Integer.toString(i);
                i++;
                String item_newName = dstName.replaceAll("#i#", n);
                File item = new File(dst.getPath() + "\\" + s);
                File item_new = new File(dst.getPath() + item_newName);
                System.out.println("[" + item.getName() + "] renameTo [" + item_new.getName() + "] is [" + item.renameTo(item_new) + "]");
            }
        }
    }

}
