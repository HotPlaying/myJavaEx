package com.test.experiment.ex7;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author trd
 * @since 2021/11/25 10:38
 */
public class CeLue {

    private static Map<String, Consumer<String>> FUNC_MAP = new ConcurrentHashMap<>();
    private static String MAN = "man";
    private static String WOMAN = "woman";

    static {
        FUNC_MAP.put(MAN, person -> System.out.println(person + "应该去男厕所"));
        FUNC_MAP.put(WOMAN, person -> System.out.println(person + "应该去女厕所"));
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setGender(MAN);
        p.setName("张三");
        Person p2 = new Person();
        p2.setGender(WOMAN);
        p2.setName("张三他老婆");

        FUNC_MAP.get(p.getGender()).accept(p.name);
        FUNC_MAP.get(p2.getGender()).accept(p2.name);

    }

    @Data
    static class Person {
        private String gender;
        private String name;
    }
}
