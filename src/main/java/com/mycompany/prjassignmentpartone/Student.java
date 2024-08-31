/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjassignmentpartone;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author matth
 */
public class Student {
      public static ArrayList<arrayClass> students = new ArrayList<>();

    public void start()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("********************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
       
        
        String select = in.nextLine();
  
        if (select.equals("1"))
        {
            System.out.println("Please Select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application.");
            
            select = in.nextLine();
            
            switch(select)
            {
                case "1":
                    saveStudent(in);
                    break;
                case "2":
                    searchStudent(in);
                    break;
                case "3":
                    deleteStudent(in);
                    break;
                 case "4":
                   studentReport();
                    break;
                 case "5":
                    exitStudentApplication();
                    break;
                 default:
                       System.out.println("Invalid option");
            }
        }
           else
        {
              exitStudentApplication();
        }
    }            
              
    
                
        public void saveStudent(Scanner in)
   
        {
             
            System.out.println("Enter a student id: ");
            String id = in.nextLine();
            
            System.out.println( "Enter the student name: " );
            String name = in.nextLine();
            
          int age;
while (true) 
{
    System.out.println("Enter the student age: ");
    if (in.hasNextInt()) 
    {           
        age = in.nextInt();
        in.nextLine();

        if (age >= 16) 
        {
            break;
        } 
        else 
        {
            System.out.println("You have entered an incorrect student age!!!");
          
        }
    } 
    else
    {
            System.out.println("You have entered an incorrect student age!!!");
          
        in.nextLine(); 
    }
}
            
            System.out.println("Enter the student email: ");
            String email = in.nextLine();
            
            System.out.println("Enter the student course: ");
            String course = in.nextLine();
            
          arrayClass newStudent = new arrayClass(id, name, age, email, course);
          students.add(newStudent);
          
            System.out.println("Student details succesfully captured. \n");
          
            System.out.println("CAPTURE A NEW STUDENT");
            System.out.println("********************************************");
            System.out.println(newStudent);
            System.out.println("Enter (1) to launch menu or any other key to exit");
           String select = in.nextLine();


           if (select.equals("1"))
        {
         start();
        }
           else
        {
             exitStudentApplication();
        }
      
        }
        
        
        public void searchStudent(Scanner in)
        {
            System.out.println("Enter a student ID to search.");
            String id = in.nextLine();
            
            boolean found = false;
            for (arrayClass student :students)
            {
                if (student.getId().equals(id))
                {
                    System.out.println("Student found.");
                    System.out.println(student);
                    found = true;
                    break;
                    
                }
            }
            if (!found)
            {
                System.out.println("No students found with ID number: " + id);
            }
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String select = in.nextLine();
            
            if (select.equals("1"))
            {
                start();
            }
            else
            {
           exitStudentApplication();
            }
        }
        
        
   public void deleteStudent(Scanner in) 
   {
        System.out.println("Enter a student ID to delete.");
        String id = in.nextLine();

        boolean found = false;
        arrayClass studentToDelete = null;

       
        for (int i = 0; i < students.size(); i++) 
        {
            if (students.get(i).getId().equals(id)) 
            {
                studentToDelete = students.get(i);
                found = true;
                break;
            }
        }

        if (found) 
        {
         
            System.out.println("Enter the student id to delete: " + studentToDelete);
            System.out.println("Are you sure you want to delete student from the system? Yes (y) to delete.");
            String confirmation = in.nextLine().trim().toLowerCase();

            if (confirmation.equals("y")) 
            {
                students.remove(studentToDelete);
                System.out.println("Student with student Id: " + id + " WAS deleted!");
            } 
            else 
            {
                System.out.println("Invalid input. Deletion cancelled.");
            }
        } 
        else 
        {
            System.out.println("No students found with ID number: " + id);
        }

        System.out.println("Enter (1) to launch menu or any other key to exit");
        String select = in.nextLine();

        if (select.equals("1")) 
        {
            start();
        }
        else 
       {
            exitStudentApplication();
        }
    }
   
   
   public void studentReport() 
   {
        if (students.isEmpty()) 
        {
            System.out.println("No students available.");
        } 
        else 
        {
            System.out.println("STUDENT REPORT");
            System.out.println("********************************************");
            for (arrayClass student : students) {
                System.out.println(student);
            }
        }

        System.out.println("Enter (1) to launch menu or any other key to exit");
        Scanner in = new Scanner(System.in);
        String select = in.nextLine();

        if (select.equals("1")) 
        {
            start();
        } 
        else 
        {
          exitStudentApplication();
        }
   }
   
   
        public void exitStudentApplication()
        {
            System.exit(0);
        }
}

  

