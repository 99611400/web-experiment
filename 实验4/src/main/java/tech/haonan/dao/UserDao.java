package tech.haonan.dao;

import tech.haonan.entity.User;

/**
 * @Author: yhn
 * @Date: 2020/9/24 23:31
 * @Description:
 **/
public interface UserDao {
    User findByUserName(String username,String password);
}
