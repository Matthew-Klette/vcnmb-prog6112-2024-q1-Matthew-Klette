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
    void testSearchStudent() //Checks to see if a student can be searched for
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
        assertNotNull(foundStudent, "Student found");
        assertEquals(id, foundStudent.getId(), "Student ID found");
        assertEquals("Matt", foundStudent.getName(), "Student name found");
        assertEquals(20, foundStudent.getAge(), "Student age found");
        assertEquals("matt@gmail.com", foundStudent.getEmail(), "Student email found");
        assertEquals("PROG5122", foundStudent.getCourse(), "Student course found");
    }

    @Test
    void testSearchStudent_StudentNotFound() //Checks to see if a student will not be found
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
        
        assertNull(foundStudent, "No student found");
    }

    @Test
    void testDeleteStudent() //Checks to see if a student can be deleted
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

        assertEquals(0, students.size(), "Student deleted");
    }

    @Test
    void testDeleteStudent_StudentNotFound() //Checks to see if a student has been deleted
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

        assertEquals(1, students.size(), "No student found");
    }
    
    @Test
    public void testSaveStudent() //cHECKS for correct student details
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

        assertEquals(id, savedStudent.getId(), "Valid");
        assertEquals(name, savedStudent.getName(), "Valid");
        assertEquals(age, savedStudent.getAge(), "Valid");
        assertEquals(email, savedStudent.getEmail(), "Valid");
        assertEquals(course, savedStudent.getCourse(), "Valid");
    }
    
     @Test
    void testStudentAge_StudentAgeValid()//Checks for a valid student age
    {
        Scanner in = new Scanner("20\n");

        boolean isValid = validateStudentAge(in);

        assertTrue(isValid, "Valid.");
    }

    @Test
    void testStudentAge_StudentAgeInvalid() //cHECKS FOR AN INVALID STUDENT AGE
    {
        Scanner in = new Scanner("11\n");

        boolean isValid = validateStudentAge(in);

        assertFalse(isValid, "Invalid.");
    }

    @Test
    void testStudentAge_StudentAgeInvalidCharacter()//Checks if the student age is not a numerical value
    {
        Scanner in = new Scanner("asdasdasdasdasd\n");
        boolean isValid = validateStudentAge(in);

        assertFalse(isValid, "Invalid.");
    }

    private boolean validateStudentAge(Scanner in) 
    {
        while (true) 
        {
            System.out.println("Enter the students age: ");
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