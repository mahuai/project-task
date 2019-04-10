package com.pro.task.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: admin
 * @Date: 2019/4/10 13:58
 * @Description:
 */
@Component
public class AutowiredUtil {

    @Autowired
    private static AutowireCapableBeanFactory capableBeanFactory;

    public static void addAutowire(Object object){
        capableBeanFactory.autowireBean(object);
    }
}
