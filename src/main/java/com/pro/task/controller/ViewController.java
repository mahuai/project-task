package com.pro.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: admin
 * @Date: 2019/4/10 16:39
 * @Description:
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/taskList")
    public Object taskList(){
        return "task-list";
    }

}
