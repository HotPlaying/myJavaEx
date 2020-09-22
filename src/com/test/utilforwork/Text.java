package com.test.utilforwork;

import java.util.List;

/**
 * @author tangrd
 * @date 2020/9/22 10:35
 * @description
 */
public class Text {
    public List<String> textList;

    public Text(List<String> textList) {
        this.textList = textList;
    }

    public String toLower() {
        StringBuilder sb = new StringBuilder();
        for (String s : textList) {
            sb.append(s.toLowerCase()).append('\n');
        }
        return sb.toString();
    }
}
