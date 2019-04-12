package com.pro.task.controller;

import com.pro.task.entity.Task;
import com.pro.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/10 15:00
 * @Description:
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/list")
    public String taskListUI(ModelMap model) {
        try {
            List<Task> taskList = taskService.getTaskList();
            model.addAttribute("taskList", taskList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "task-list";
    }

    @GetMapping("/add")
    public String addTaskUI() {
        return "task-add";
    }

    @GetMapping("/update")
    public String updateTask(ModelMap model, @RequestParam(required = true, value = "id") Integer id) {
        try {
            Task task = taskService.getIdByTask(id);
            model.addAttribute("task", task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "update-task";
    }
}
