/*
 * This is an solution for the program which forms the second
 * Practical Skills Assessment on COM102.
 * Created by: Niall Morrissey (B00787301), Michael Brown (B00808857)
 * Date: 18/04/2021
 * Version: 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class holds the main functionality of the program.
 * It initialises the program, reads in & processes both student and course
 * detail text files, and provides a menu system for the user to navigate.
 */

public class Main 
    {
    private int selection;
    private Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) 
        {
        //Instantiating self class to declare instance variables and
        //avoid the need to make more methods static.
        Main enrolmentRegister = new Main();
        enrolmentRegister.initialise(); 
        }
    
    private void initialise()
        {
        //Instantiating Student_Register class to populate Student array
        //and call Student_Register methods within navigation menu
        Student_Register studentObject = new Student_Register();
        
        // open the text file
        Scanner studentTxtFile = null;
        Scanner courseTxtFile = null;
        try
            { 
            studentTxtFile = new Scanner(new File("StudentDetails.txt"));
            courseTxtFile = new Scanner(new File("CourseDetails.txt"));
            } 
        catch (FileNotFoundException ex)
            {
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
            }
        
        //read and process each record from the StudentDetails.txt
        studentTxtFile.nextLine(); //skips the header record
        studentTxtFile.useDelimiter(","); //splits variables where comma is present
        while(studentTxtFile.hasNextLine())
            {
            //passing through records from studentTxtFile to Student_Register class constructor
            studentObject.addStudent(studentTxtFile.next(), studentTxtFile.next(), studentTxtFile.next(), studentTxtFile.next()); 
            studentTxtFile.nextLine();
            }
        
        //read and process each record from the CourseDetails.txt
        //instantiating course class and passing through records from studentTxtFile to Course class constructor
        Course courseObject = new Course(courseTxtFile.nextLine(), courseTxtFile.nextLine(),
            Double.parseDouble(courseTxtFile.nextLine()),Double.parseDouble(courseTxtFile.nextLine()),
                    Double.parseDouble(courseTxtFile.nextLine())); 
        
        //close the file
        studentTxtFile.close();
        courseTxtFile.close();
        
        while(true) //whilst true, while loop prints menu options to console
            {
            System.out.println("\n-----------The Enrolment Register-----------");
            System.out.println("----------------Menu Options----------------");
            System.out.println("1.) List Student Names");
            System.out.println("2.) Add New Student");
            System.out.println("3.) Delete Existing Student");
            System.out.println("4.) Display Specific Student Details");
            System.out.println("5.) Display Report Details");
            System.out.println("6.) Save and Exit");
            System.out.println("--------------------------------------------");
            System.out.print("Enter Value of Menu Choice: ");
            
            selection = scan.nextInt(); //user selects menu option as interger

            switch(selection)  //switch reads and processes user selected value
                {
                case 1:
                    studentObject.listStudentNames();
                    break;
                case 2:
                    studentObject.createStudent();
                    courseObject.updatedDetails(studentObject.maleFemalePerc(), studentObject.total());
                    break;    
                case 3:
                    studentObject.deleteStudent();
                    courseObject.updatedDetails(studentObject.maleFemalePerc(), studentObject.total());
                    break;         
                case 4:
                    studentObject.searchStudentDetails();
                    break;
                case 5:
                    courseObject.printCourseDetails();
                    break;      
                case 6:
                    System.out.println("Changes Saved. Exiting Program");
                    studentObject.saveStudentDetails();
                    courseObject.updatedDetails(studentObject.maleFemalePerc(), 
                            studentObject.total());
                    courseObject.saveCourseDetails();
                    System.exit(0);
                    break;
                default: //if user interger entered not found, prompt re-entry
                    System.out.println("--------------------------------");
                    System.out.println("Invalid Entry. Please Try Again");
                    System.out.println("--------------------------------");
                 break;
                }
            }
        }
    }// End of class Main