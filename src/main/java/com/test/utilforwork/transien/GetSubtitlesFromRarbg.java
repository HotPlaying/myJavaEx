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
public class GetSubtitlesFromRarbg {

    @Test
    public void test() throws IOException {
//        String source = "F:\\Video\\Animation\\Cyberpunk.Edgerunners.S01.JAPANESE.1080p.WEBRip.x265-RARBG";
//        String source = "F:\\Video\\Animation\\DOTA.Dragons.Blood.S01.1080p.WEBRip.x265-RARBG";
//        String source = "F:\\Video\\Animation\\DOTA.Dragons.Blood.S02.1080p.WEBRip.x265-RARBG";
        String source = "F:\\Video\\Animation\\DOTA.Dragons.Blood.S03.1080p.WEBRip.x265-RARBG";
        String dir = source + "\\Subs";
        String targetDir = source + "\\ssss";
        File f = new File(dir);
        String[] list = f.list();

        File tar = new File(targetDir);
        if (tar.exists() && tar.isDirectory()) {
            tar.mkdir();
        }

        String subName = "Chinese";
        for (String parentDirName : list) {
            String subParentDir = dir + File.separator + parentDirName;
            File subParentFile = new File(subParentDir);
            String[] files = subParentFile.list();
            String name = null;
            for (String sub : files) {
                if (sub.contains(subName)) {
                    name = sub;
                    break;
                }
            }
            if (null == name) {
                continue;
            }
            String subDir = subParentDir + File.separator + name;
            File srcSubFile = new File(subDir);
            String newSubDir = targetDir + "\\" + parentDirName + ".srt";
            File newSubFile = new File(newSubDir);
            FileUtils.copyFile(srcSubFile, newSubFile);
        }
        System.out.println(Arrays.toString(list));
    }
}
