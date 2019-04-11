package com.pro.task.controller;

import com.pro.task.entity.Task;
import com.pro.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/10 16:39
 * @Description:
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/taskList")
    public String taskListUI(ModelMap model) {
        Task task=taskService.getIdByTask(1);
        model.addAttribute("task",task);
        return "task-list";
    }

    @GetMapping("/addTask")
    public String addTaskUI() {
        return "task-add";
    }

    @GetMapping("/updateTask")
    public String updateTask() {
        return "update-task";
    }

}
