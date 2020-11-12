package tech.haonan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yhn
 * @Date: 10/25/2020 7:53 PM
 * @Description:
 **/
@Controller
public class indexController {
    @RequestMapping("/index")
    public String workBench(){
        return "redirect:/pages/workbench.html";
    }
}
