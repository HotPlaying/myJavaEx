package com.test.experiment.interview.yifangda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangrd
 * @since 2022/9/9 17:26
 */
public class LongestList {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 4, 7, 5);
        List<Integer> longestList = LongestList.getLongestList(integers);
        List<Integer> integers1 = Arrays.asList(2, 2, 2, 2, 2);
        List<Integer> longestList1 = LongestList.getLongestList(integers1);
        System.out.println(longestList);
        System.out.println(longestList1);
    }

    public static List<Integer> getLongestList(List<Integer> srcList) {
        List<Integer> ansList = null;

        List<Integer> tempList = new ArrayList<>();
        tempList.add(srcList.get(0));
        for (int i = 1; i < srcList.size(); i++) {
            if (srcList.get(i) <= srcList.get(i - 1)) {
                if (ansList == null || tempList.size() > ansList.size()) {
                    ansList = tempList;
                }
                tempList = new ArrayList<>();
                tempList.add(srcList.get(i - 1));
                break;
            }
            tempList.add(srcList.get(i));

        }
        return ansList;
    }
}
