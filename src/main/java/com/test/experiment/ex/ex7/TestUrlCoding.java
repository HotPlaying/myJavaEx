package com.test.experiment.ex.ex7;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author tangrd
 * @date 2020/7/29 15:43
 * @description test url coding
 */
public class TestUrlCoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "企业规模";
        final String CODE = "%E4%BC%81%E4%B8%9A%E8%A7%84%E6%A8%A1";
        System.out.println("1: " + URLEncoder.encode(CODE, String.valueOf(StandardCharsets.UTF_8)));
        System.out.println("2: " + URLEncoder.encode(name, String.valueOf(StandardCharsets.UTF_8)));
        System.out.println("3: " + URLDecoder.decode(CODE, String.valueOf(StandardCharsets.UTF_8)));
        System.out.println("4: " + URLDecoder.decode(name, String.valueOf(StandardCharsets.UTF_8)));
        String value = "%";
        try {
            System.out.println("5: " + URLDecoder.decode(value, String.valueOf(StandardCharsets.UTF_8)));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        value = value.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        System.out.println("6: " + URLDecoder.decode(value, String.valueOf(StandardCharsets.UTF_8)));
        value = "('、\\\"、+、%、&、<>、（）、;、~!@#$%^&*()_+|}{\\\":?></+";
        System.out.println("7: " + value);
        value = value.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        System.out.println("8: " + URLDecoder.decode(value, String.valueOf(StandardCharsets.UTF_8)));
        value = "、";
//        value = value.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        System.out.println("9: " + URLDecoder.decode(value, String.valueOf(StandardCharsets.UTF_8)));
        String kongge = URLEncoder.encode(" ", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(kongge);
        System.out.println("9.1: " + URLDecoder.decode(" ", String.valueOf(StandardCharsets.UTF_8)));
        System.out.println("9.2: " + URLDecoder.decode("+", String.valueOf(StandardCharsets.UTF_8)));
        System.out.println("10: " + URLDecoder.decode(kongge, String.valueOf(StandardCharsets.UTF_8)));
        System.out.println("11: " + URLDecoder.decode("%20", String.valueOf(StandardCharsets.UTF_8)));
        // " "对应两个编码，'%20'和'+'
    }
}
