package com.test.utilforwork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author tangrd
 * @date 2020/9/22 10:12
 * @description
 */
public class OutputUtil {
    public static Boolean outToLog(final String content) {
        return outToLog("F:\\logs\\", ".log", content);
    }

    public static Boolean outToLog(final String path, final String fileType, final String content) {
        String datetime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss").format(LocalDateTime.now());
        File file = new File(path + datetime + fileType);
        try {
            file.createNewFile();
            byte[] bytes = content.getBytes();
            Files.write(file.toPath(), bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("输出完成，文件路径: " + file.toPath());
        return true;
    }
}
