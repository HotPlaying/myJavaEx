package com.test.experiment.ex7;

import java.util.Map;

/**
 * @author tangrd
 * @date 2020/11/26 19:28
 * @description
 */
public class TestMethodParam {
    public static void main(String[] args) {
//        User a = new User();
//        System.out.println(isEmpty(a.getPassword()));
//        a = null;
//        System.out.println(isEmpty(a.getPassword()));
        String custId = "1231212123123";
        String WHERE_CONDITION = " AND cust_acct_no = {} OR idno = {}";
        System.out.println(WHERE_CONDITION.replaceAll("\\{}", custId));
    }

    public static void changeTheMap(Map<String, Object> map) {
        Object a =  map.get("a");
        a = "qweqwe";
    }

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s.trim()) || "null".equals(s.trim());
    }
}
