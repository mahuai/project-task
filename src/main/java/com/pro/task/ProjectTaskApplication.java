package com.pro.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.pro.task.dao.*")
public class ProjectTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTaskApplication.class, args);
    }

}
