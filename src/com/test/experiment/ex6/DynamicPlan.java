package com.test.experiment.ex6;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

/**
 * @author tangrd
 * @date 2021/7/14 20:59
 */
public class DynamicPlan {



    /**
     * 4	1,
     * 7	1,
     * 6	2,
     * 6	2,
     * 6	2,
     * 9	2,
     * 11	3,
     * 12	3,
     */
    public static void main(String[] args) {
        dp1();
    }

    public static void dp0() {
        int[] w = new int[501];
        int[] v = new int[501];
        int[] f = new int[200001];
        for (int i = 0; i < 200001; i++)
            f[i] = 0;

        int n = 8, l = 40;

        w = new int[]{4, 7, 6, 6, 6, 9, 11, 12};
        v = new int[]{1, 1, 2, 2, 2, 2, 3, 3};
        for (int i = 1; i <= n; i++)
            for (int j = l; j >= w[i]; j--)
                f[j] = max(f[j - w[i]] + v[i], f[j]);

        System.out.println(f[l]);
    }

    public static void dp1() {
        List<Item> itemList = new ArrayList<>(50);

        int[] totalValue = new int[200001];
        for (int i = 0; i < 200001; i++)
            totalValue[i] = 0;

        int itemCount = 8, capacity = 40;
        String json = "{\n" +
                "  \"List\": [\n" +
                "    { \"weight\": 4, \"value\": 1 },\n" +
                "    { \"weight\": 7, \"value\": 1 },\n" +
                "    { \"weight\": 6, \"value\": 2 },\n" +
                "    { \"weight\": 6, \"value\": 2 },\n" +
                "    { \"weight\": 6, \"value\": 2 },\n" +
                "    { \"weight\": 9, \"value\": 2 },\n" +
                "    { \"weight\": 11, \"value\": 3 },\n" +
                "    { \"weight\": 12, \"value\": 3 }\n" +
                "  ]\n" +
                "}\n";
        JSONObject jsonObject = (JSONObject) JSON.parse(json);
        itemList = JSON.parseArray(jsonObject.get("List").toString(), Item.class);
        for (Item item : itemList) {
            for (int j = capacity; j >= item.weight; j--) {
                totalValue[j] = max(totalValue[j - item.weight] + item.value, totalValue[j]);
            }
        }
        System.out.println(totalValue[capacity]);
    }
}
