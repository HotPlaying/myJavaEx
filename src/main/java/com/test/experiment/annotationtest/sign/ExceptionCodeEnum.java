package com.test.experiment.annotationtest.sign;

import lombok.Data;

/**
 * @author tangrd
 * @since 2021/10/5 21:31
 */
public enum ExceptionCodeEnum {
    SUCCESS(200, "success"),
    ERROR(501, "error"),
    INVALID(301, "invalid"),
    FAILED(300, "failed");


    Integer code;
    String desc;

    ExceptionCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
