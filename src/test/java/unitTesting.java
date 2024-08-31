/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.prjassignmentpartone.Student;
import com.mycompany.prjassignmentpartone.arrayClass;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author matth
 */public class unitTesting 
{
    private Student studentManager;
    private final String existingStudentId = "ST10249706";
    private final String nonExistingStudentId = "999";
    
    @BeforeEach
    void setUp() 
    {
        studentManager = new Student();
        Student.students.clear(); 
    }

    @Test
    void testSearchStudent() 
    {
        studentManager.saveStudent(existingStudentId, "Matt", 20, "matt@gmail.com", "PROG5122");
        
        String id = existingStudentId;
        ArrayList<arrayClass> students = Student.students;
        arrayClass foundStudent = null;

        for (arrayClass student : students)
        {
            if (student.getId().equals(id)) 
            {
                foundStudent = student;
                break;
            }
        }
        assertNotNull(foundStudent, "Student should be found in the list");
        assertEquals(id, foundStudent.getId(), "Student ID should match");
        assertEquals("Matt", foundStudent.getName(), "Student name should match");
        assertEquals(20, foundStudent.getAge(), "Student age should match");
        assertEquals("matt@gmail.com", foundStudent.getEmail(), "Student email should match");
        assertEquals("PROG5122", foundStudent.getCourse(), "Student course should match");
    }

    @Test
    void testSearchStudent_StudentNotFound() 
    {
        String id = nonExistingStudentId;
        ArrayList<arrayClass> students = Student.students;
        arrayClass foundStudent = null;

        for (arrayClass student : students) 
        {
            if (student.getId().equals(id)) 
            {
                foundStudent = student;
                break;
            }
        }
        
        assertNull(foundStudent, "No student should be found in the list");
    }

    @Test
    void testDeleteStudent() 
    {
        studentManager.saveStudent(existingStudentId, "Matt", 20, "matt@gmail.com", "PROG5122");
        
        String id = existingStudentId;
        ArrayList<arrayClass> students = Student.students;
        arrayClass studentToDelete = null;

        for (arrayClass student : students)
       {
            if (student.getId().equals(id)) 
            {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete != null) 
        {
            students.remove(studentToDelete);
        }

        assertEquals(0, students.size(), "Student should be removed from the list");
    }

    @Test
    void testDeleteStudent_StudentNotFound() 
    {
        studentManager.saveStudent(existingStudentId, "Matt", 20, "matt@gmail.com", "PROG5122");

        String id = nonExistingStudentId;
        ArrayList<arrayClass> students = Student.students;
        arrayClass studentToDelete = null;

        for (arrayClass student : students) 
        {
            if (student.getId().equals(id)) 
            {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete != null) 
        {
            students.remove(studentToDelete);
        }

        assertEquals(1, students.size(), "No student should be removed from the list");
    }
    
    @Test
    public void testSaveStudent() 
    {
        String id = "ST10249706";
        String name = "Matt";
        int age = 20;
        String email = "matt@gmail.com";
        String course = "PROG5122";

        studentManager.saveStudent(id, name, age, email, course);

        ArrayList<arrayClass> students = Student.students;
        assertEquals(1, students.size(), "Student should be saved in the list");
        arrayClass savedStudent = students.get(0);

        assertEquals(id, savedStudent.getId(), "Student ID should match");
        assertEquals(name, savedStudent.getName(), "Student name should match");
        assertEquals(age, savedStudent.getAge(), "Student age should match");
        assertEquals(email, savedStudent.getEmail(), "Student email should match");
        assertEquals(course, savedStudent.getCourse(), "Student course should match");
    }
    
     @Test
    void testStudentAge_StudentAgeValid()
    {
        Scanner in = new Scanner("20\n");

        boolean isValid = validateStudentAge(in);

        assertTrue(isValid, "The student's age should be valid.");
    }

    @Test
    void testStudentAge_StudentAgeInvalid() 
    {
        Scanner in = new Scanner("15\n");

        boolean isValid = validateStudentAge(in);

        assertFalse(isValid, "The student's age should be invalid as it is less than 16.");
    }

    @Test
    void testStudentAge_StudentAgeInvalidCharacter()
    {
        Scanner in = new Scanner("abc\n");
        boolean isValid = validateStudentAge(in);

        assertFalse(isValid, "The input should be invalid as it is not a number.");
    }

    private boolean validateStudentAge(Scanner in) 
    {
        while (true) 
        {
            System.out.println("Enter the student age: ");
            if (in.hasNextInt()) 
            {
                int age = in.nextInt();
                in.nextLine(); 
                return age >= 16;
            } 
            else 
            {
                in.nextLine(); 
                return false;
            }
        }
    }
}