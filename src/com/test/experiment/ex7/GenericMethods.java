package com.test.experiment.ex7;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    public static <T, O> List<T> getFieldList(List<O> oList, String fieldName) {
        if (CollectionUtils.isEmpty(oList) || StringUtils.isEmpty(fieldName)) {
            return null;
        }
        List<T> tList = new ArrayList<>();
        Field[] fields = oList.get(0).getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!fieldName.equals(field.getName())) continue;
            for (O o : oList) {
                try {
                    tList.add((T) field.get(o));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            break;
        }

        return tList;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("a001", "b001", "c001", "d001"));
        userList.add(new User("a002", "b002", "c002", "d002"));
        userList.add(new User("a003", "b003", "c003", "d003"));
        userList.add(new User("a004", "b004", "c004", "d004"));
        List<String> useridList = getFieldList(userList, "userid");
        System.out.println(useridList);
    }
}
