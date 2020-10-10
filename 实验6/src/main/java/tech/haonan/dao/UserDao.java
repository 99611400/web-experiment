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
    public List<User> findAll();
    //保存用户
    //Integer id, String username, String password, String email, Integer age, String tel, String addr, String idNumber, Integer married, Double salary
//    @Insert("insert into userTable (username,password,email,tel,idNumber,salary) values (#{username},#{password},#{email},#{tel},#{idNumber},#{salary})")
    public void saveUser(User user);


//    @Select("select * from usertable where username = #{username} and password = #{password}")
    public User getUserByUserNameAndPasswd(@Param("username") String username, @Param("password")String password);


//    @Select("select count(*) from userTable where username = #{username}")
    public Integer queryDuplicateOfUsername(@Param("username")String username);


//    @Select("select count(*) from userTable where email = #{email}")
    public Integer queryDuplicateOfEmail(@Param("email")String email);

//    @Select("select count(*) from userTable where tel = #{tel}")
    public Integer queryDuplicateOfTel(@Param("tel")String tel);

//    @Select("select count(*) from userTable where idNumber = #{idNumber}")
    public Integer queryDuplicateOfIdNumber(@Param("idNumber")String idNumber);
}
