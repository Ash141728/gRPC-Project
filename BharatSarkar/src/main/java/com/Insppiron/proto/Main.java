package com.Insppiron.proto;

import com.Insppiron.proto.Controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);
//        run.getBean(StudentController.class);
    }

}