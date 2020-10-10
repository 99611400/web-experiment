import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import tech.haonan.dao.UserDao;
import tech.haonan.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: yhn
 * @Date: 10/8/2020 11:29 PM
 * @Description:
 **/
public class TestMyBatis {
    // 测试查询全部
    @Test
    public void test1(){
        //加载mybatis的配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建sqlSessionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //创建SqlSession对象
            SqlSession session = factory.openSession();
            //获取代理对象
            UserDao mapper = session.getMapper(UserDao.class);

            //查询所有信息
             List<User> userList = mapper.findAll();
             for(User user : userList){
                 System.out.println(user);
             }
             session.close();
             inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    // 测试保存 注册用户 insert sql语句
//    @Test
//    public void test2(){
//        //加载mybatis的配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //创建sqlSessionFactory对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //创建SqlSession对象
//            SqlSession session = factory.openSession();
//            //获取代理对象
//            UserDao mapper = session.getMapper(UserDao.class);
//            //Integer id, String username, String password, String email, Integer age, String tel, String addr, String idNumber, Integer married, Double salary
//            User userxx = new User("aaa",
//                    "bbb",
//                    "aaa@gmail.com",
//                    29,
//                     "man",
//                    "1389427129",
//                    "qingdao",
//                    "370876214481020123",
//                    true,
//                    3000f
//                    );
//            mapper.saveUser(userxx);
//            session.commit();
//            session.close();
//            inputStream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    //测试 通过用户名和密码 查询用户
//    @Test
//    public void test3(){
//        //加载mybatis的配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //创建sqlSessionFactory对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //创建SqlSession对象
//            SqlSession session = factory.openSession();
//            //获取代理对象
//            UserDao mapper = session.getMapper(UserDao.class);
//            //Integer id, String username, String password, String email, Integer age, String tel, String addr, String idNumber, Integer married, Double salary
//
//            User user = mapper.getUserByUserNameAndPasswd("123","afdafsd");
//            System.out.println(user);
//            inputStream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //测试 username  email tel 和 idNumber 不能重复
//    @Test
//    public void test4(){
//        //加载mybatis的配置文件
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //创建sqlSessionFactory对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            //创建SqlSession对象
//            SqlSession session = factory.openSession();
//            //获取代理对象
//            UserDao mapper = session.getMapper(UserDao.class);
//            //Integer id, String username, String password, String email, Integer age, String tel, String addr, String idNumber, Integer married, Double salary
//
//            System.out.println(mapper.queryDuplicateOfUsername("zhang"));
//            System.out.println(mapper.queryDuplicateOfEmail("123@gmail.com"));
//            System.out.println(mapper.queryDuplicateOfTel("13209875609"));
//            System.out.println(mapper.queryDuplicateOfIdNumber("370183199901434102479"));
//            inputStream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
