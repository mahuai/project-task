package com.pro.task.job;

import com.pro.task.entity.Task;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: admin
 * @Date: 2019/4/10 16:09
 * @Description:
 */
@Component
public class TaskManager {

    @Autowired
    private Scheduler scheduler;

    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);

    public void addTask(Task task) {
        try {
            Class<? extends Job> object = (Class<? extends Job>) (Class.forName(task.getClassName()).newInstance().getClass());
            JobDetail detail = JobBuilder.newJob(object).withIdentity(task.getTaskName(), task.getTaskGroup()).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(task.getTaskName(), task.getTaskGroup())
                    .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                    .withSchedule(CronScheduleBuilder.cronSchedule(task.getCron())).startNow().build();
            scheduler.scheduleJob(detail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            logger.error("添加任务异常：", e);
        }
    }


    /**
     * 暂停任务
     *
     * @param task
     * @throws SchedulerException
     */
    public void pauseTask(Task task) {
        try {
            JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            logger.error("暂停任务失败：", e);
        }
    }

    /**
     * 开启任务
     * @param task
     */
    public void openTask(Task task) {
        try {
            JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            logger.error("开启任务失败：", e);
        }
    }


    /**
     * 删除一个job
     *
     * @param task
     * @throws SchedulerException
     */
    public void deleteTask(Task task) {
        try {
            JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            logger.error("删除任务失败：", e);
        }
    }


    /**
     * 立即执行job
     *
     * @param task
     * @throws SchedulerException
     */
    public void runTaskNow(Task task)   {
        try {
            JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            logger.error("立即执行任务失败：", e);
        }
    }
}
