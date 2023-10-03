
/**
 * Write a description of class StudentStatistics here.
 *
 * @author (Sandesh Adhikari)
 * @version (0.5)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

class Student {
    String lastName;
    String firstName;
    String studentID;
    double a1;
    double a2;
    double a3;

    public Student(String lastName, String firstName, String studentID, double a1, double a2, double a3) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }


}

public class StudentStatistics
{
    private List<Student> students;

    public StudentStatistics() {
        students = new ArrayList<>();
}
}
