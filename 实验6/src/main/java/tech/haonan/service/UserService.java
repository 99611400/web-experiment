package tech.haonan.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.haonan.dao.UserDao;
import tech.haonan.entity.User;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 10/8/2020 8:37 PM
 * @Description: 服务层接口
 **/

public interface UserService {


    //查询所有账户信息
    public List<User> findAll();
    //保存用户
    public void saveUser(User user);
    //通过用户名和密码来查询用户
    public User getUserByUserNameAndPasswd(String username,String password);

    public Integer queryDuplicateOfUsername(String username);

    public Integer queryDuplicateOfEmail(String email);

    public Integer queryDuplicateOfTel(String tel);

    public Integer queryDuplicateOfIdNumber(String idNumber);
}
