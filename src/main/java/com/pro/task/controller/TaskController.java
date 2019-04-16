package com.pro.task.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.pro.task.entity.Task;
import com.pro.task.job.TaskManager;
import com.pro.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private TaskManager taskManager;

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


    @PostMapping("/doAdd")
    @ResponseBody
    public String doAdd(Task task) {
        int result;
        try {
            if (null == task) {
                return "task not be null";
            }
            result = taskService.addTask(task);
            if (result > 0) {
                taskManager.addTask(task);
                return result + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "add task error";
        }
        return null;
    }

    @PostMapping("/doUpdate")
    @ResponseBody
    public String doUpdate(@RequestBody Task task) {
        int result;
        try {
            result = taskService.updateBySelective(task);
            if (result > 0) {
                return result + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/doDel")
    @ResponseBody
    public String doDel(Integer id) {
        int result;
        try {
            if ("".equals(id) || null == id) {
                return "id not be null";
            }
            Task task = taskService.getIdByTask(id);
            taskManager.deleteTask(task);
            result = taskService.deleteTask(id);
            if (result > 0) {
                return result + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "del task error";
        }
        return null;
    }

    @PostMapping("/pauseAndOpenTask")
    @ResponseBody
    public String pauseTask(Integer id, Integer status) {
        int result;
        try {
            if (null==id || null==status) {
                return "id and status not be null";
            }
            Task task = taskService.getIdByTask(id);
            if (status > 0) {
                taskManager.pauseTask(task);
            } else {
                taskManager.openTask(task);
            }
            result = taskService.updateBySelective(new Task(id, status));
            if (result > 0) {
                return result + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "open or pause error";
        }
        return null;
    }
}
