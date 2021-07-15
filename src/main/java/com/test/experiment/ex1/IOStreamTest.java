package com.test.experiment.ex1;


import java.io.File;
import java.io.IOException;

public class IOStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\85753\\Downloads\\ziyuan");
        printFile(file);

        String[] pathList = file.list();
        assert pathList != null;
        for (String fL : pathList) {
            System.out.println(fL);
//            printFile(new File(fL));
        }
//        System.out.println(file.createNewFile());
//        System.out.println(file.delete());
    }
    static void printFile(File f) {
        File[] files = f.listFiles();
        assert files != null;
        for (File file : files) {
            System.out.println(file);
        }
    }
}
