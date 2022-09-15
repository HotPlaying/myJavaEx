package com.test.utilforwork.transien;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author tangrd
 * @since 2022/6/5 23:14
 */
public class CompareF {
    public static void main(String[] args) throws IOException {
        List<String> excludeList = Arrays.asList(
                "Yuukoku no Moriarty",
                "Paprika",
                "Back Arrow"
        );

        String localPath = "H:\\Media\\Video\\Animation";
        Set<String> localFileSets = getFileSets(localPath);
        Set<String> movableFileSets = getFileSets("I:\\Video\\AnimationBD");


        Set<String> collect = localFileSets
                .stream()
                .filter(v -> movableFileSets.contains(v) && v.startsWith("["))
//                .filter(v -> excludeList.stream().noneMatch(v::contains))
                .collect(Collectors.toSet());
        for (String s : collect) {
            System.out.println(s);
        }
        for (String s : collect) {
            s = localPath + "\\" + s;
            File fileToDelete = new File(s);
            boolean exists = fileToDelete.exists();
//            System.out.println(s + "exists: " + exists);
//            FileUtils.deleteDirectory(fileToDelete);
        }

    }

    private static Set<String> getFileSets(String s2) {
        String path1 = s2;
        File file1 = new File(path1);
        File[] files1 = file1.listFiles();
        List<File> fileList1 = Arrays.asList(files1);
        return fileList1
                .stream()
                .map(v -> v.getName()).collect(Collectors.toSet());
    }
}
