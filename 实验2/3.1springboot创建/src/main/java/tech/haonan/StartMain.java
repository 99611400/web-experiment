package tech.haonan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author: yhn
 * @Date: 2020/9/11 12:28
 * @Description:
 **/
@ServletComponentScan("tech.haonan.servlet")
@SpringBootApplication
public class StartMain {
    public static void main(String[] args) {
        SpringApplication.run(StartMain.class,args);
    }
}
