package tech.haonan.Service;

import tech.haonan.dao.UserDao;
import tech.haonan.dao.UserDaoImpl;
import tech.haonan.entity.User;

/**
 * @Author: yhn
 * @Date: 2020/9/24 23:13
 * @Description:
 **/
public class LoginServiceImpl implements LoginService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User findByUserName(String username,String password) {
//        return null;
        return userDao.findByUserName(username,password);
    }
}
