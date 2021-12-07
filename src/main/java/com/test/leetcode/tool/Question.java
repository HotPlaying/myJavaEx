package com.test.leetcode.tool;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author tangrd
 * @since 2021/12/6 22:41
 */
@NoArgsConstructor
@AllArgsConstructor
public abstract class Question {
    protected Params params;

    abstract public Object run();

    protected static class Params {

    }
}
