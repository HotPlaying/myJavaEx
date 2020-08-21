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
        File dst = new File("D:\\Video\\Animation\\_字幕\\[异域-11番小队]零之使魔2双月的骑士Zero_no_Tsukaima_2_Futatukinokishi[HKG&amp;amp;EMD字幕]");
        File src = new File("D:\\Video\\Animation\\[VCB-Studio] Zero no Tsukaima\\[VCB-Studio] Zero no Tsukaima Princess no Rondo [Ma10p_1080p]");
        assert dst.isDirectory();
        assert src.isDirectory();
        List<String> srcFileList = Arrays.asList(src.list());
        List<String> dstFileList = Arrays.asList(dst.list());

        int i = 0;

        for (String s : srcFileList) {
            if (s.matches(".*\\.mkv")) {
                String fileNewName = s.split("\\.")[0] + ".ass";
//                String n = i < 10 ? "0" + i : Integer.toString(i);
                File item = new File(dst.getPath() + "\\" + dstFileList.get(i++));
                File item_new = new File(dst.getPath() + "\\" + fileNewName);
//                System.out.printf("[%s] renameTo [%s]\\n",item.getName(),item_new.getName());

                System.out.printf("[%s] renameTo [%s] is [%s]\\n",item.getName(),item_new.getName(),item.renameTo(item_new));
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
