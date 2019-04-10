package com.pro.task.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/10 15:00
 * @Description:
 */
@Mapper
public interface TaskDao<T> {

    /**
     * 根据ID获取任务
     * @param id
     * @return
     */
    T getIdByTask(@Param("id") Integer id);

    /**
     * 获取所有任务
     * @return
     */
    List<T> getTaskList();


    /**
     * 添加任务
     * @param t
     * @return
     */
    Integer addTask(T t);

    /**
     * 修改部分选项
     * @param t
     * @return
     */
    Integer updateBySelective(T t);


    /**
     * 根据ID删除任务
     * @param id
     * @return
     */
    Integer deleteTask(@Param("id") Integer id);


    /**
     *  获取条数
     * @return
     */
    Integer queryCount(T t);


    /**
     * 获取分页列表
     * @param t
     * @return
     */
    List<T> getPageList(T t);

}



