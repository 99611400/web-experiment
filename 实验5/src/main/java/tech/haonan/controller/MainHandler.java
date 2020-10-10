package tech.haonan.controller;

/**
 * @Author: yhn
 * @Date: 10/4/2020 6:56 PM
 * @Description:
 **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainHandler {
    @PostMapping(value = "/login" )
    public ModelAndView index(String username, String password ){
        ModelAndView modelAndView = new ModelAndView("success");
        // 存入信息 以便jsp文件中使用
        modelAndView.addObject("username",username);
        return modelAndView;
    }
}
