package com.pro.task.configuration;

import com.pro.task.util.AutowiredUtil;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: admin
 * @Date: 2019/4/10 15:06
 * @Description:
 */
@Component
public class JobFactory extends AdaptableJobFactory {

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        AutowiredUtil.addAutowire(jobInstance);
        return jobInstance;
    }
}
