package com.pro.task.service.impl;

import com.github.pagehelper.PageHelper;
import com.pro.task.dao.TaskDao;
import com.pro.task.entity.Task;
import com.pro.task.service.TaskService;
import com.pro.task.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/10 14:53
 * @Description:
 */
@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskDao<Task> taskDao;

    @Override
    public Task getIdByTask(Integer id) {
        Task task;
        try {
            task = taskDao.getIdByTask(id);
            return task;
        } catch (Exception e) {
            logger.error("获取任务异常:", e);
        }
        return null;
    }

    @Override
    public List<Task> getTaskList() {
        List<Task> taskList;
        try {
            taskList = taskDao.getTaskList();
            return taskList;
        } catch (Exception e) {
            logger.error("获取任务异常:", e);
        }
        return null;
    }

    @Override
    public Integer addTask(Task o) {
        Integer result;
        try {
            result = taskDao.addTask( o);
            return result;
        } catch (Exception e) {
            logger.error("获取任务异常:", e);
        }
        return 0;
    }

    @Override
    public Integer updateBySelective(Task o) {
        Integer result;
        try {
            result = taskDao.updateBySelective( o);
            return result;
        } catch (Exception e) {
            logger.error("修改任务异常:", e);
        }
        return 0;
    }

    @Override
    public Integer deleteTask(Integer id) {
        Integer result;
        try {
            result = taskDao.deleteTask(id);
            return result;
        } catch (Exception e) {
            logger.error("删除任务异常:", e);
        }
        return 0;
    }

    @Override
    public Integer queryCount(Task o) {
        Integer result;
        try {
            result = taskDao.queryCount(o);
            return result;
        } catch (Exception e) {
            logger.error("获取任务异常:", e);
        }
        return 0;
    }

    @Override
    public PageBean getPageList(Task o) {
        List<Task> adminList;
        Integer count;
        try {
            PageHelper.startPage(o.getPageNum(), o.getPageSize());
            adminList=taskDao.getPageList(o);
            count=taskDao.queryCount(o);
            return new PageBean<>(o.getPageNum(), o.getPageSize(), count, adminList);
        } catch (Exception e) {
            logger.error("获取分页数据异常：",e);
        }
        return null;
    }
}
