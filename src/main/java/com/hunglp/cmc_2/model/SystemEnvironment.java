package com.hunglp.cmc_2.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("systemEnv")
@Data
public class SystemEnvironment {

    @Value("#{systemEnvironment['JAVA_HOME']}")
    private String javaHome;


    @Value("#{systemEnvironment['MAVEN_HOME']}")
    private String mavenHome;

    @Value("#{systemEnvironment['OS']}")
    private String os;

    public void getSystemVar(){
        System.out.println("Java Home: " + javaHome);
        System.out.println("Maven Home: " + mavenHome);
        System.out.println("OS: " + os);
    }

}
