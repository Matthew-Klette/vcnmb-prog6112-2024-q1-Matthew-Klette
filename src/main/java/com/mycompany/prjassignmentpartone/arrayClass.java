/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjassignmentpartone;

/**
 *
 * @author matth
 */
public class arrayClass //(Farrel, J. 2019)
{
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    
    public arrayClass(String id, String name, int age, String email, String course) //(Farrel, J. 2019)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }
    
    
    
    public String getId()  //(Farrel, J. 2019)
    {
        return id;
    }

    public String getName() //(Farrel, J. 2019)
    {
        return name;
    }

    public int getAge() //(Farrel, J. 2019)
    {
        return age;
    }

    public String getEmail() //(Farrel, J. 2019)
    {
        return email;
    }

    public String getCourse() //(Farrel, J. 2019)
    {
        return course;
    }
    
    @Override //(Farrel, J. 2019)
    public String toString()
    {
        return "Enter a student id: " + id + "\n" +
                "Enter the student name: " + name + "\n" +
                "Enter the student age: " + age + "\n" +
                "Enter the student email: " + email + "\n" +
                "Enter the student course: " + course + "\n"; 
    }

    public void setId(String id)//(Farrel, J. 2019)
    {
        this.id = id;
    }

    public void setName(String name) //(Farrel, J. 2019)
    {
        this.name = name;
    }

    public void setAge(int age) //(Farrel, J. 2019)
    {
        this.age = age;
    }

    public void setEmail(String email) //(Farrel, J. 2019)
    {
        this.email = email;
    }

    public void setCourse(String course) //(Farrel, J. 2019)
    {
        this.course = course;
    }

    void add(arrayClass newStudent) {
    }
    
    
}
/* Farrell, J. 2019 Java programming. 9th Edition. 2019. Course Technology. Boston, MA: Cengage Learning
W3schools.com. (2019). Java Date and Time. [online] Available at: https://www.w3schools.com/java/java_date.asp.
W3Schools (n.d.). Java Switch. [online] www.w3schools.com. Available at: https://www.w3schools.com/java/java_switch.asp.
‌Nalawade, K. (2023). How to Write Unit Tests in Java. [online] freeCodeCamp.org. Available at: https://www.freecodecamp.org/news/java-unit-testing/.
*/
  

