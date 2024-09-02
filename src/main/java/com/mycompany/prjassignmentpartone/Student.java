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
public class Student
{

    public static ArrayList<arrayClass> students = new ArrayList<>();

    public void saveStudent(String id, String name, int age, String email, String course) //Method to save the student details
    {
        arrayClass newStudent = new arrayClass(id, name, age, email, course);//Creates a new instance of arrayclass
        students.add(newStudent);//Adds new student object to the array list
        System.out.println("Student details successfully captured.");
    }

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
            System.out.println("(4) Update Student. ");
            System.out.println("(5) Print student report. ");
            System.out.println("(6) Exit Application.");

            select = in.nextLine();

            switch (select)
            {
                case "1":
                    saveStudent(in);//Calls save student method if 1 is entered
                    break;
                case "2":
                    searchStudent(in); //calls search student method if 2 is entered
                    break;
                case "3":
                    deleteStudent(in); //calls delete student method if 3 is entered
                    break;
                case "4":
                    updateStudent(in);//calls update student method if 4 is entered
                    break;
                case "5":
                    studentReport();  //calls student report method if  5 is entered
                    break;
                case "6":
                    exitStudentApplication();//closes the program if 6 is entered
                    break;
                default:
                    System.out.println("Invalid option"); //Prints error if any other character is entered
            }
        } else
        {
            exitStudentApplication();
        }
    }

    public void saveStudent(Scanner in) //Save student method

    {

        System.out.println("Enter a student id: ");//Prompts for student id
        String id = in.nextLine();

        System.out.println("Enter the student name: "); //Prompts for student name
        String name = in.nextLine();

        int age;//Sets age to only a numerical value
        while (true) //Error checking for age
        {
            System.out.println("Enter the student age: ");
            if (in.hasNextInt())
            {
                age = in.nextInt();
                in.nextLine();

                if (age >= 16) //Checks if the age is below 16
                {
                    break;
                } else
                {
                    System.out.println("You have entered an incorrect student age!!!");

                }
            } else
            {
                System.out.println("You have entered an incorrect student age!!!");

                in.nextLine(); //reprompts
            }
        }

        System.out.println("Enter the student email: ");//prompts for student email
        String email = in.nextLine();

        System.out.println("Enter the student course: ");//prompts for student course
        String course = in.nextLine();

        arrayClass newStudent = new arrayClass(id, name, age, email, course);
        students.add(newStudent);//adds student details to the array list

        System.out.println("Student details succesfully captured. \n");

        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("********************************************");
        System.out.println(newStudent);//displays the captured details
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String select = in.nextLine();

        if (select.equals("1"))
        {
            start();
        } else
        {
            exitStudentApplication();
        }

    }

    public void searchStudent(Scanner in)//method to search for student
    {
        System.out.println("Enter a student ID to search.");
        String id = in.nextLine();

        boolean found = false;
        for (arrayClass student : students) //if ID matches a student ID in the array, details of the student are displayed
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
            System.out.println("No students found with ID number: " + id);//Display message if student is not found
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String select = in.nextLine();

        if (select.equals("1"))
        {
            start();
        } else
        {
            exitStudentApplication();
        }
    }

    public void updateStudent(Scanner in) //Method to update a student
    {
        System.out.println("Enter a student ID to update.");
        String id = in.nextLine();

        boolean found = false;
        for (arrayClass student : students) //searches for student id in array list
        {
            if (student.getId().equals(id))
            {
                found = true;

                System.out.println("Enter new details for the student.");

                System.out.println("Enter the new name (or press Enter to keep current name): ");
                String newName = in.nextLine();
                if (!newName.isEmpty())
                {
                    student.setName(newName);
                }

                System.out.println("Enter the new age (or press Enter to keep current age): ");
                String ageInput = in.nextLine();
                if (!ageInput.isEmpty())
                {
                    int newAge = Integer.parseInt(ageInput);
                    if (newAge >= 16)
                    {
                        student.setAge(newAge);
                    } else
                    {
                        System.out.println("You have entered an incorrect student age!!!");
                    }
                }

                System.out.println("Enter the new email (press Enter to keep current email): ");
                String newEmail = in.nextLine();
                if (!newEmail.isEmpty())
                {
                    student.setEmail(newEmail);
                }

                System.out.println("Enter the new course (press Enter to keep current course): ");
                String newCourse = in.nextLine();
                if (!newCourse.isEmpty())
                {
                    student.setCourse(newCourse);
                }

                System.out.println("Student details updated successfully.");
                System.out.println(student);
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
        } else
        {
            exitStudentApplication();
        }
    }

    public void deleteStudent(Scanner in) //Method to delete student
    {
        System.out.println("Enter a student ID to delete.");
        String id = in.nextLine();

        boolean found = false;
        arrayClass studentToDelete = null;//Searches for ID in the array list to delete

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
            String confirmation = in.nextLine().trim().toLowerCase();//Confirmation to delete a student

            if (confirmation.equals("y"))
            {
                students.remove(studentToDelete);
                System.out.println("Student with student Id: " + id + " WAS deleted!");
            } else
            {
                System.out.println("Invalid input. Deletion cancelled.");
            }
        } else
        {
            System.out.println("No students found with ID number: " + id);//Display message if no student was found
        }

        System.out.println("Enter (1) to launch menu or any other key to exit");
        String select = in.nextLine();

        if (select.equals("1"))
        {
            start();
        } else
        {
            exitStudentApplication();
        }
    }

    public void studentReport() //method for student report
    {
        if (students.isEmpty()) //if no students are in the array, a display message appears
        {
            System.out.println("No students available.");
        } else
        {
            System.out.println("STUDENT REPORT");
            System.out.println("********************************************");
            for (arrayClass student : students)
            {//displays students saved in the array in chronological order
                System.out.println(student);
            }
        }

        System.out.println("Enter (1) to launch menu or any other key to exit");
        Scanner in = new Scanner(System.in);
        String select = in.nextLine();

        if (select.equals("1"))
        {
            start();
        } else
        {
            exitStudentApplication();
        }
    }

    public void exitStudentApplication()//method to close the program
    {
        System.exit(0);
    }

}
