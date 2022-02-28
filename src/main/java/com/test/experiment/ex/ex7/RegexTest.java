package com.test.experiment.ex.ex7;

import java.util.Arrays;
import java.util.List;

/**
 * @author tangrd
 * @date 2020/5/20 17:15
 */
public class RegexTest {
    public static void main(String[] args) {
//        System.out.println(isPhoneNumber("14444444444"));
//        System.out.println(isPhoneNumber("13168689050"));
        System.out.println(isEmail("123@qwe.com"));
        System.out.println(isEmail("123@qwecom"));
        System.out.println(isEmail("123123.com"));
        List<String> stringList = Arrays.asList("123@qwe.com", "123@qwecom", "123123.com");
        List<String> appr_statList = Arrays.asList("123@qwe.com", "123@qwecom", "123123.com");
//        String appr_statListString = "('" + StringUtils.join(appr_statList, "','") + ")";
//        String WHERE_CONDITION = "AND appr_stat IN (" + appr_statListString + ")";
//        System.out.println(WHERE_CONDITION);
    }

    static Boolean isPhoneNumber(String phoneNumber) {
        String rex = "[1]\\d{10}";
        return phoneNumber.matches(rex);
    }

    static Boolean isEmail(String email) {
        String rex = "\\w+[@]\\w(2)";
        return email.matches(rex);
    }

}
