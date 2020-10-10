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


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/loginJsp")
    public String login(){
        return "login";
    }

    @RequestMapping("/registerJsp")
    public String register(){
        return "register";
    }

    @RequestMapping("/register")
    public ModelAndView register(String username,String password){
        Random r = new Random();
        Integer randomNumber;
        ModelAndView modelAndView = new ModelAndView();
        if(userService.queryDuplicateOfUsername(username) == 1){ // 说明用户名重复
            modelAndView.setViewName("registerError");
            modelAndView.addObject("username",username);
        }else{
            while (true){
                randomNumber = r.nextInt(900);
                randomNumber += 100;
                if(userService.queryDuplicateOfTel("1312891" + randomNumber.toString()) != 1)
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

    @RequestMapping("/login")
    public ModelAndView login(String username,String password){
        ModelAndView modelAndView = new ModelAndView();
        if(userService.getUserByUserNameAndPasswd(username,password) == null){
            modelAndView.setViewName("login");
            modelAndView.addObject("error","用户名或者密码错误");
        }else{
            modelAndView.setViewName("loginSuccess");
            modelAndView.addObject("username",username);
        }
        return modelAndView;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll( ){
        ModelAndView modelAndView = new ModelAndView("findAll");
        System.out.println("controller层测试成功");
        // 调用service方法
        List<User> userList = userService.findAll();
        modelAndView.addObject("list",userList);
        return modelAndView;
    }
}
