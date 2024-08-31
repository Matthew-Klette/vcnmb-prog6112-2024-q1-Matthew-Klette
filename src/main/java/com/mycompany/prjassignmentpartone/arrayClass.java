/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjassignmentpartone;

/**
 *
 * @author matth
 */
public class arrayClass 
{
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    
    public arrayClass(String id, String name, int age, String email, String course)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }
    
    
    
    public String getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getCourse() 
    {
        return course;
    }
    
    @Override
    public String toString()
    {
        return "Enter a student id: " + id + "\n" +
                "Enter the student name: " + name + "\n" +
                "Enter the student age: " + age + "\n" +
                "Enter the student email: " + email + "\n" +
                "Enter the student course: " + course + "\n"; 
    }

    void add(arrayClass newStudent) {
    }
    
    
}
