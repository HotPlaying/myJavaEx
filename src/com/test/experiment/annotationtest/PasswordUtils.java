package com.test.experiment.annotationtest;

/**
 * @author tangrd
 * @date 2021/5/25 11:46
 * @description
 */

/**
 * 使用注解：
 */
public class PasswordUtils {
    @UseCase(id = "47", description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = "48")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
