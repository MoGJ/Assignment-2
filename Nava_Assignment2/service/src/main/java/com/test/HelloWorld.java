/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.bulletinspace.service.Course;
import com.bulletinspace.service.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author dawit.gebremichael
 */
@Component
public class HelloWorld {
    
    @Autowired
    private Course course;
    
    private String name;

    public String getName() {
        return name;
    }
    
    public void addCourse(){
        course.setGrade(77);
        course.setName("Bob");
        System.out.println(" "+course.getName());
//        Course c = new Course();
//        c.setGrade(22);
//        c.setName("Bob");
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public  void display() {
        System.out.println("Hello world "+name);
    }
    
    
    public static void main(String[] args) {
        
      
        ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
        HelloWorld helloWorld = (HelloWorld)context.getBean("hellWorld");
        helloWorld.addCourse();
    }
    
    
}
