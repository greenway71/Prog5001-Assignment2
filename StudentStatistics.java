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
import java.io.IOException;

class Student {
    String lastName;
    String firstName;
    String studentID;
    double a1;
    double a2;
    double a3;
    double totalMark;

    public Student(String lastName, String firstName, String studentID, double a1, double a2, double a3) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.totalMark = a1 + a2 + a3;
    }
    public double getTotalMark() {
        return totalMark;
    
    }
    
}

public class StudentStatistics {
    private List<Student> students;

    public StudentStatistics() {
        students = new ArrayList<>();
    }

    public void readFromFile(String fileName) {
        try {
            // Open and read the data from the file.
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the first two lines of the file.
            String unitName = bufferedReader.readLine(); // Store the UnitName as String.
            bufferedReader.readLine(); // Store the headers of student stats in the buffer to read.

            System.out.println("Unit Name: " + unitName.substring(6)); // Print the Unitname from Index position six.

            // Checking and Ignoring Comments that start with "#"
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Ignore lines that start with #
                if (line.trim().startsWith("#")) {
                    continue;
                }

                String[] data = line.split(","); // Storing the data into an array and splitting with a comma.
                if (data.length >= 6) { // Conditional statement to check elements in the array.
                    String lastName = data[0].trim();
                    String firstName = data[1].trim();
                    String studentID = data[2].trim();

                    // Check for whitespace or null values before parsing as double.
                    double a1 = parseDoubleWithDefault(data[3].trim(), 0.0);
                    double a2 = parseDoubleWithDefault(data[4].trim(), 0.0);
                    double a3 = parseDoubleWithDefault(data[5].trim(), 0.0);

                    System.out.println("Student Name: " + firstName + " " + lastName);
                    System.out.println("Student ID: " + studentID);
                    System.out.println("A1: " + a1);
                    System.out.println("A2: " + a2);
                    System.out.println("A3: " + a3);
                    System.out.println();

                    // Create a new student and add to the list
                    Student student = new Student(lastName, firstName, studentID, a1, a2, a3);
                    students.add(student);
                }
            }

            // Close the file
            bufferedReader.close(); // Close the file.
        } catch (IOException e) { // Throw this error if any exception.
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private double parseDoubleWithDefault(String str, double defaultValue) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    public void calculateTotalMarks() {
        System.out.println("Calculating total marks of students.");
        for (Student student : students) {
            System.out.println("Student Name: " + student.firstName + " " + student.lastName);
            System.out.println("Student ID: " + student.studentID);
            System.out.println("Total Mark: " + student.getTotalMark());
            System.out.println();
        }
    }
    
    
    public void StudentsMarksThreshold(double threshold) {
        System.out.println("Printing students with total marks below the threshold: " + threshold);
        for (Student student : students) {
            if (student.getTotalMark() < threshold) {
                System.out.println("Student Name: " + student.firstName + " " + student.lastName);
                System.out.println("Student ID: " + student.studentID);
                System.out.println("Total Mark: " + student.getTotalMark());
                System.out.println();
            }
        }
    
   
        
    }
    
    public void TopAndBottomStudentsMarks() {
    List<Student> topStudents = new ArrayList<>();
    List<Student> bottomStudents = new ArrayList<>();
}
    
    
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStatistics studentStats = new StudentStatistics();
        scanner.nextLine(); // newline.
        System.out.print("Enter the name of your file with its extension: ");
        String fileName = scanner.nextLine();
        studentStats.readFromFile(fileName);
        studentStats.calculateTotalMarks();
        System.out.print("Enter the threshold: ");
        double threshold = scanner.nextDouble();
        studentStats.StudentsMarksThreshold(threshold);
        
    }
}
