package tech.haonan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tech.haonan.entity.User;
import tech.haonan.service.UserService;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: yhn
 * @Date: 10/8/2020 6:49 PM
 * @Description: web层
 **/
@Controller
public class LoginHandler {
    // set注入 这个推荐
    private UserService userService;
    @Autowired
    public void setUserService (UserService userService) {
        this.userService = userService;
    }

    // 跳转到index.jsp
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    //跳转到login.jsp
    @RequestMapping("/loginJsp")
    public String login(){
        return "login";
    }

    //跳转到register.jsp
    @RequestMapping("/registerJsp")
    public String register(){
        return "register";
    }


    // 注册接口
    @RequestMapping("/register")
    public ModelAndView register(String username,String password){
        Random r = new Random();
        Integer randomNumber;
        ModelAndView modelAndView = new ModelAndView();
        //查询是否用户名重复
        if(userService.queryDuplicateOfUsername(username) == 1){ // 说明用户名重复
            modelAndView.setViewName("registerError");
            modelAndView.addObject("username",username);
        }else{
            while (true){// 循环寻找一个不重复的数字  因为我的user对象里边不止id username password这3个属性
                randomNumber = r.nextInt(900);
                randomNumber += 100;
                if(userService.queryDuplicateOfTel("1312891" + randomNumber.toString()) != 1)  //如果发现不重复条吹u循环
                    break;
            }
            User user = new User(
                    username,
                password,
                    username+"@qq.com",
                null,
                null,
                "1312891" + randomNumber.toString(),
                null,
                "370819199303211" + randomNumber.toString(),
                true,
                (float)(randomNumber + 3000)
            );
            userService.saveUser(user);
            User sqlUser = userService.getUserByUserNameAndPasswd(username,password);
            modelAndView.addObject("user",sqlUser);
            modelAndView.setViewName("registerSuccess");
        }
        return modelAndView;

    }

    // 登录接口
    @RequestMapping("/login")
    public ModelAndView login(String username,String password){
        ModelAndView modelAndView = new ModelAndView();
        if(userService.getUserByUserNameAndPasswd(username,password) == null){  // 如果不匹配说明用户名或者密码有问题
            modelAndView.setViewName("login");
            modelAndView.addObject("error","用户名或者密码错误");
        }else{  // 如果用户名和密码正确 那么跳转到登录成功
            modelAndView.setViewName("loginSuccess");
            modelAndView.addObject("username",username);
        }
        return modelAndView;
    }

    // 返回数据库所有数据 用表格的方法列出来
    @RequestMapping("/findAll")
    public ModelAndView findAll( ){
        ModelAndView modelAndView = new ModelAndView("findAll");
        System.out.println("controller层测试成功");
        // 调用service方法
        List<User> userList = userService.findAll();
        // 把list 带到前端 然后遍历列出
        modelAndView.addObject("list",userList);
        return modelAndView;
    }
}
