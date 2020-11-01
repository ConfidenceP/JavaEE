package me.confidence.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Child implements Serializable {
    
    private Logger logger;

    private String name;
    private int age;

    // No argument constructor
    public Child() {
    }

    @PostConstruct
    private void init() {
        logger.log(Level.INFO, "*******************************************");
        logger.log(Level.INFO, "Child bean called");
        logger.log(Level.INFO, "*******************************************");
    }

    @PreDestroy
    private void end() {
        logger.log(Level.INFO, "*******************************************");
        logger.log(Level.INFO, "Child bean ready for garbage collection");
        logger.log(Level.INFO, "*******************************************");
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
