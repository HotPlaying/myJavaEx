package com.test.experiment.ex7;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tangrd
 * @date 2020/9/18 11:34
 * @description
 */
public class ReflectionOne {
    public static void main(String[] args) throws IllegalAccessException {
        List<User> userList = new ArrayList<>();
        userList.add(new User("a001", "b001", "c001", "d001"));
        userList.add(new User("a002", "b002", "c002", "d002"));
        userList.add(new User("a003", "b003", "c003", "d003"));
        userList.add(new User("a004", "b004", "c004", "d004"));
        List<String> useridList = getFieldList(userList, "userid");
        for (String s : useridList) {
            if(s.equals("b002")) {
                int index = useridList.indexOf(s);
                s = "002";
                useridList.set(index, s);
            }
        }
        System.out.println("ok");
    }

    @Test
    public void testSetValueFor() {
        User o = new User();
        String fieldName = "type";
        Field [] fields = o.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.getName().matches(fieldName + "\\d{1,2}")) {
                    field.setAccessible(true);
                    field.set(o, "1");
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(o);
    }

    public static void printObject(Object o) {
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                System.out.println(f.getName() + ": " + f.get(o));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        User user = new User("1", "1", "1", "1");

        setObject(user);
        System.out.println(user);
    }

    public static void setObject(User user) {
//        user = new User("a003", "b003", "c003", "d003");
        user.setPassword("a003");
    }

    public static Object setNullToEmptyString(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new ConcurrentHashMap<>();
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.get(obj) == null) {
                    if (field.getType() == String.class)
                        field.set(obj, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将存储于List中的对象的一个属性值单独取出成一个List
     *
     * @Author tangrd
     * @Date 2020/9/23 15:09
     **/
    public static List<String> getFieldList(List objectList, final String fieldName) {
        if (objectList == null || objectList.isEmpty()) {
            return null;
        }
        List<String> fieldvalueList = new ArrayList<>();
        try {
            Field [] fields = objectList.get(0).getClass().getDeclaredFields();
            for (Field field: fields) {
                if (field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    for (Object obj : objectList) {
                        fieldvalueList.add((String) field.get(obj));
                    }
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fieldvalueList;
    }
}
