package tech.haonan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tech.haonan.entity.Worker;
import tech.haonan.service.WokerService;

import java.util.List;
import java.util.Random;

/**
 * @Author: yhn
 * @Date: 11/12/2020 7:11 PM
 * @Description:
 **/
@Controller
public class WorkerHandler {
    @Autowired
    private WokerService wokerService;

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

    //跳转到update.jsp
    @RequestMapping("/update")
    public String update(){
        return "updatehhh";
    }


    //跳转到update.jsp
    @RequestMapping("/search")
    public String search(){
        return "search";
    }








    // 返回数据库所有数据 用表格的方法列出来
    @RequestMapping("/findAll")
    public ModelAndView findAll( ){
        ModelAndView modelAndView = new ModelAndView("findAll");
        System.out.println("controller层测试成功");
        // 调用service方法
        List<Worker> workerList = wokerService.findAll();
        // 把list 带到前端 然后遍历列出
        modelAndView.addObject("list",workerList);
        return modelAndView;
    }

    @RequestMapping("/searchWorker")
    public ModelAndView searchWorker(Worker worker){
        System.out.println("afjdsljflkasdjlkfjsadlkjflkjasldfjlasdjlfjlkasjdfjlasjf");
        System.out.println(worker);
        ModelAndView modelAndView = new ModelAndView("searchResult");
        // 调用service方法
        List<Worker> workerList = wokerService.searchWorker(worker);
        // 把list 带到前端 然后遍历列出
        modelAndView.addObject("list",workerList);
        return modelAndView;
    }
}
