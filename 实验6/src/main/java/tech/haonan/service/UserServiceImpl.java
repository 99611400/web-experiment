package tech.haonan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.haonan.dao.UserDao;
import tech.haonan.entity.User;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 10/8/2020 8:38 PM
 * @Description:
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    // 自动注入dao层的东西
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        System.out.println("service层 查询所有");
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        System.out.println("service层 保存用户");
        userDao.saveUser(user);
    }

    @Override
    public User getUserByUserNameAndPasswd(String username, String password) {
        return userDao.getUserByUserNameAndPasswd(username,password);
    }

    @Override
    public Integer queryDuplicateOfUsername(String username) {
        return userDao.queryDuplicateOfUsername(username);
    }
    @Override
    public Integer queryDuplicateOfEmail(String email) {
        return userDao.queryDuplicateOfEmail(email);
    }
    @Override
    public Integer queryDuplicateOfTel(String tel) {
        return userDao.queryDuplicateOfTel(tel);
    }
    @Override
    public Integer queryDuplicateOfIdNumber(String idNumber) {
        return userDao.queryDuplicateOfIdNumber(idNumber);
    }


}
