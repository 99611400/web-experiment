package tech.haonan.Service;

import tech.haonan.entity.User;

/**
 * @Author: yhn
 * @Date: 2020/9/24 23:12
 * @Description:
 **/
public interface LoginService {
    User findByUserName(String username,String password);
}
