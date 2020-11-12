package tech.haonan.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.haonan.entity.User;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 10/8/2020 8:34 PM
 * @Description: 用户接口 查询用户
 **/
// mybatis dao层只需要写接口就行 不需要写实现类
@Repository
public interface UserDao {
    //查询所有账户信息
//    @Select("select * from userTable")
    //查询所有用户
    public List<User> findAll();
    //Integer id, String username, String password, String email, Integer age, String tel, String addr, String idNumber, Integer married, Double salary
//    @Insert("insert into userTable (username,password,email,tel,idNumber,salary) values (#{username},#{password},#{email},#{tel},#{idNumber},#{salary})")
    //保存用户
    public void saveUser(User user);


//    @Select("select * from usertable where username = #{username} and password = #{password}")
    // 通过用户名和密码寻找用户
    public User getUserByUserNameAndPasswd(@Param("username") String username, @Param("password")String password);


//    @Select("select count(*) from userTable where username = #{username}")
    // username判断是否是重复的
    public Integer queryDuplicateOfUsername(@Param("username")String username);


//    @Select("select count(*) from userTable where email = #{email}")
    // email 判断是否是重复的
    public Integer queryDuplicateOfEmail(@Param("email")String email);

//    @Select("select count(*) from userTable where tel = #{tel}")
    // tel 判断是否是重复的
    public Integer queryDuplicateOfTel(@Param("tel")String tel);

//    @Select("select count(*) from userTable where idNumber = #{idNumber}")
    // 身份证判断是否是重复的
    public Integer queryDuplicateOfIdNumber(@Param("idNumber")String idNumber);
}
