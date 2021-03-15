package com.test.experiment.ex7;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author tangrd
 * @date 2020/7/27 17:30
 * @description 日期类的使用与测试
 */
public class TestLocalTime {
    public static void main(String[] args) {
        // adapted to java 1.7
//        Calendar c = Calendar.getInstance();
//        String dateTime = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(c.getTime());
//        System.out.println(dateTime);

        // adapted to java 1.8 or newer
        System.out.println(LocalDateTime.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss");
        System.out.println(dtf.format(LocalDateTime.now()));

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);//得到前一个月
        String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        System.out.println(dateTime);
    }
}
