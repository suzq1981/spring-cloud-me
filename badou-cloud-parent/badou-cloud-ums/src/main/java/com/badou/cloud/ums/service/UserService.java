package com.badou.cloud.ums.service;

import com.badou.cloud.ums.entity.User;

public interface UserService {

    void createUser(User user);

    void updateUser(User user);

    User findUserById(Integer userId);

}
