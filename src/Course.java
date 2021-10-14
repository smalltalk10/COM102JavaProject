/*
 * This is an solution for the  program which forms the second
 * Practical Skills Assessment on COM102.
 * Created by: Niall Morrissey (B00787301), Michael Brown (B00808857)
 * Date: 18/04/2021
 * Version: 1.0
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class holds the Course functionality of the program and that
 * methods that can be called from the main class user menu
 */

public class Course 
    {
    protected String lecName, courseName;
    protected double malePerc, femalePerc, totalStudents;
    
    // constructor to create instance variables of Course details 
    protected Course (String lecName, String courseName, double malePerc, double femalePerc, double totalStudents)
        {
        this.lecName = lecName;
        this.courseName = courseName;
        this.malePerc = malePerc;
        this.femalePerc = femalePerc;
        this.totalStudents = totalStudents;
        }
    protected void updatedDetails(double malePerc, double totalStudents)
        {
        // method tochange instance variable values when
        // called after student details have been altered
        this.malePerc = malePerc;
        this.femalePerc = 100-malePerc;
        this.totalStudents = totalStudents;
        }
    
    protected void printCourseDetails()
        { 
        // method to print out the details of course
        System.out.println("\n------Course Details------");
        System.out.println("Lecturer Name " + lecName);
        System.out.println("Course Name: " + courseName);
        System.out.printf("Male Percentage: " + "%.2f", malePerc);
        System.out.println("%");
        System.out.printf("Female Percentage: " + "%.2f", femalePerc);
        System.out.println("%");
        System.out.println("Total Students: " + totalStudents);
        }
    protected void saveCourseDetails()
        {
        // method to save and output course details to text file when called
        PrintWriter out = null;
        try
            { 
            out = new PrintWriter("CourseDetails.txt");
            } 
        catch (FileNotFoundException ex)
            { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
            }
        
        //process and output and  each record from the file
        out.println(lecName);
        out.println(courseName);
        out.println(malePerc);
        out.println(femalePerc);
        out.println(totalStudents);

        out.close(); // close PrintWriter class
        }
    }// End of class Course
