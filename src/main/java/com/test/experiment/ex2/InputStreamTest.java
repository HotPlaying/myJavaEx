package com.test.experiment.ex2;

import java.io.IOException;
import java.util.StringJoiner;

public class InputStreamTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] members = {"1", "17", "18"};
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String member : members) {
            stringJoiner.add(member);
        }
        System.out.println(stringJoiner.toString());
        System.out.println(String.valueOf(22));
    }
}
