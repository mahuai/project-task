package com.pro.task.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: admin
 * @Date: 2019/4/10 14:42
 * @Description:
 */
@Component
public class BatchTask implements Job {

    private static final Logger logger= LoggerFactory.getLogger(BatchTask.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("--------------start task---------------");
        logger.info("--------------execute task-------------");
    }
}
