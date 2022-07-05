package com.hunglp.cmc_2;

import com.hunglp.cmc_2.config.AppConfig;
import com.hunglp.cmc_2.config.SecurityConfig;
import com.hunglp.cmc_2.model.Student;
import com.hunglp.cmc_2.model.SystemEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.security.auth.message.config.AuthConfig;

@SpringBootApplication
public class Cmc2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Cmc2Application.class, args);

        // Read var from application,  use @value
        Student student = context.getBean(Student.class);
        student.display();

        // Read var from application,  use @PropertySource
        AppConfig appConfig = context.getBean(AppConfig.class);
        appConfig.getDBConfig();

        // Read var from command line
        // spring-boot:run -Dspring-boot.run.arguments=ABCCCCC
        if (args.length > 0) {
            for (String arg : args) {
                System.out.println("Arguments : " + arg);
            }
        }

        // Read var from System Env, Use @value
        SystemEnvironment systemEnvironment = context.getBean(SystemEnvironment.class);
        systemEnvironment.getSystemVar();

//        // Read bean base on Profile // Error
//        SecurityConfig securityConfig = context.getBean(SecurityConfig.class);



        // Run Profile using JVM System Parameter (Should use)
        // spring-boot:run -Dspring.profiles.active=local

        // Maven clean install with profile:
        // mvn clean package -Pdev
        // Hoac : mvn clean package -Plocal

    }


}
