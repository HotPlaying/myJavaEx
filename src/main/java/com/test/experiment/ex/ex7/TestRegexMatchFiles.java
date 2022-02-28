package com.test.experiment.ex.ex7;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangrd
 * @date 2021/2/22 11:08
 * @description
 */
public class TestRegexMatchFiles {
    public static void main(String[] args) {
        String filePattern = "/data/logs/.+\\.log";
        File f = new File(filePattern);
        File parentDir = f.getParentFile();
        String regex = f.getName();
        FileSystem FS = FileSystems.getDefault();
        final PathMatcher matcher = FS.getPathMatcher("regex:" + regex);

        DirectoryStream.Filter<Path> fileFilter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return matcher.matches(entry.getFileName()) && !Files.isDirectory(entry);
            }
        };

        List<File> result = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(parentDir.toPath(), fileFilter)) {
            for (Path entry : stream) {
                result.add(entry.toFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (File file : result) {
            System.out.println(file.getParent() + "/" + file.getName());
        }

    }
}
