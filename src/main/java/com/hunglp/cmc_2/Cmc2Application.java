package com.hunglp.cmc_2;

import com.hunglp.cmc_2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Cmc2Application {



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Cmc2Application.class, args);
        Student student = (Student)context.getBean(Student.class);
        student.display();

    }
//
//    @Override
//    public void run( ApplicationArguments args ) throws Exception
//    {
//        System.out.println( "Name: " + name );
//    }

}
