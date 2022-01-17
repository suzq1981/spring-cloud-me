package com.badou.cloud.ums.dao;

import com.badou.cloud.ums.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    void createUser(User user);

    void updateUser(User user);

    User findUserById(Integer userId);

}
