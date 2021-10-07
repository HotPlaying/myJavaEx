package com.test.experiment.annotationtest.sign;

import com.test.experiment.pojo.User;

import java.util.List;

/**
 * @author tangrd
 * @since 2021/10/5 23:19
 */
public class ModelController {
    @Signed
    public Result<User> getUserData(Integer token) {
        User user = new User("a001", "b001", "c001", "d001");
        return Result.success(user);
    }
}
