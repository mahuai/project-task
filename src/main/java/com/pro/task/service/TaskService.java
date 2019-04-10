package com.pro.task.service;

import com.pro.task.entity.Task;
import com.pro.task.util.PageBean;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/10 14:53
 * @Description:
 */
public interface TaskService {

    /**
     * 根据ID获取任务
     * @param id
     * @return
     */
    Task getIdByTask(Integer id);

    /**
     * 获取所有任务
     * @return
     */
    List<Task> getTaskList();


    /**
     * 添加任务
     * @param task
     * @return
     */
    Integer addTask(Task task);

    /**
     * 修改部分选项
     * @param task
     * @return
     */
    Integer updateBySelective(Task task);


    /**
     * 根据ID删除任务
     * @param id
     * @return
     */
    Integer deleteTask(Integer id);


    /**
     *  获取条数
     * @return
     */
    Integer queryCount(Task task);

    /**
     * 获取分页列表
     * @param task
     * @return
     */
    PageBean<Task> getPageList(Task task);

}
