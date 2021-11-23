package com.test.experiment.ex7;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author tangrd
 * @date 2021/7/18 18:04
 * @description
 */
public class TestVarargs {
    public static void main(String[] args) {
        String a = null;
        String b = "abc";
        String c = "123";

        List<String> aaa = new LinkedList<>();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", a);
        jsonObject.put("b", b);
        jsonObject.put("c", c);

        setJSONObjBlankToNULL(jsonObject);
        setBlankToNULL(a, b, c);
        System.out.println("sss");
    }

    public static void setBlankToNULL(String... strings) {
        for (String string : strings) {
            string = StringUtils.isEmpty(string) ? "NULL" : string;
        }
    }

    public static void setJSONObjBlankToNULL(JSONObject jsonObject) {
        Set<String> keySet = jsonObject.keySet();
        for (String s : keySet) {
            String v = jsonObject.getString(s);
            v = StringUtils.isEmpty(v) ? "NULL" : v;

            jsonObject.put(s, v);
        }
    }
}
