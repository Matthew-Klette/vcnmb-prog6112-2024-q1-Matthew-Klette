/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.prjassignmentpartone.Student;
import com.mycompany.prjassignmentpartone.arrayClass;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author matth
 */
public class unitTesting 
{
    private Student studentManager;

    @BeforeEach
    public void setUp()
    {
        studentManager = new Student();
        Student.students.clear();
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
}