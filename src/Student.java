/*
 * This is an solution for the  program which forms the second
 * Practical Skills Assessment on COM102.
 * Created by: Niall Morrissey (B00787301), Michael Brown (B00808857)
 * Date: 18/04/2021
 * Version: 1.0
 */

public class Student 
    {    
    protected String name, dob, address, gender;
    
    // constructor to create instance variables of each register array entry 
    public Student (String name, String dob, String address, String gender)
        {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        }
    protected void listNames()
        { 
        // prints out the name of student when called
        System.out.println("Student Name: " + this.name);
        }
    protected void printDetails()
        { 
        // // prints out the details of a student when called
        System.out.println("\n-----Student Details------");
        System.out.println("Name: " + this.name);
        System.out.println("DOB: " + this.dob);
        System.out.println("Address: " + this.address);
        System.out.println("Gender: " + this.gender);
        }
    }// End of class Student
 