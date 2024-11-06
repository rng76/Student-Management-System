package studentProject3;

import java.util.Random;
import java.util.Scanner;

public class RasoolGhalyan_Section502_Project3 {

	public static void main(String[] args) {
        Scanner obj = new Scanner(System.in); // Scanner object for user input
        boolean exit = false; // variable  to control the program exit

        // Initial message for the user
        System.out.println("Welcome to Student Management System!\n"
                + " \n"
                + "This system will allow you to manage students. Let’s start with the number of students this system will have: ");

        int arraySize = 0; // Variable to hold the number of students
        boolean validInput = false;// Variable to make sure that the user's input is valid 

        
        // Gather the number of students to manage
        do {
            System.out.print("Enter the number of students: ");
            if (obj.hasNextInt()) {
                arraySize = obj.nextInt();
                validInput = true;
            } else {
                System.out.println("Please enter a valid number.");
                obj.next(); 
            }
        } while (!validInput);

        theStudent[] students = new theStudent[arraySize]; // Object Array to store students
        int studentCount = 0; // Variable to keep track of the number of students added

        do {
            // Menu for user options
            System.out.println("\n***Welcome to Student Management System***\n"
                    + "Press ‘1’ to add a student\n"
                    + "Press ‘2’ to deactivate a student\n"
                    + "Press ‘3’ to display all students\n"
                    + "Press ‘4’ to search for a student by ID\n"
                    + "Press ‘0’ to exit the system\n");

            int num = 0;
            boolean validOption = false;

            // check if user input for the menu is valid
            do {
                if (obj.hasNextInt()) {
                    num = obj.nextInt();
                    validOption = true;
                } 
                
                else {
                    System.out.println("Invalid input. Please enter a number.");
                    obj.next(); 
                }
            } while (!validOption);

            
            if (num == 1) {
                // Option to add a student
                if (studentCount < students.length) 
                
                {
                    System.out.println("Enter first name: ");
                    String firstName = obj.next();//Taking in the first name of the student 
                    System.out.println("Enter last name: ");
                    String lastName = obj.next();//Taking in the last name of the student 
                    System.out.println("Enter level of the student: ");
                    String level = obj.next();//Taking in the level of the student 

                    // Create a new student object and add it to the previous array
                    students[studentCount] = new theStudent(firstName, lastName, level, true);
                    System.out.println(firstName + " " + lastName + " has been added as a " + level + " with ID " + students[studentCount].getStudentId());
                    studentCount++;
                } 
                
                else {
                    System.out.println("Maximum number of students reached!");
                }
            } 
            
            
            else if (num == 2) {
                // Option to deactivate a student
                System.out.println("Enter the ID for the student you want to deactivate: ");
                int deactivateId = obj.nextInt();//Get the id that the user wants to deactivate
                
                for (int i = 0; i < studentCount; i++) {// This for-loop goes through the array and find the id that needs to be deactivated 
                    if (students[i].getStudentId() == deactivateId) {
                        students[i].setActive(false);
                        System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " has been deactivated");//Lets the user know that the student has been deactivated 
                    }
                }
            } 
            
            else if (num == 3) {
                // Option to display all active students
                for (int i = 0; i < studentCount; i++) {
                    if (students[i].isActive()) {// Checks if the student is active 
                    	//Then the code prints the traits of the students 
                        System.out.println(students[i].getFirstName() + " " + students[i].getLastName());
                        System.out.println("ID: " + students[i].getStudentId());
                        System.out.println("Level: " + students[i].getLevel());
                        System.out.println("Status: " + (students[i].isActive() ? "Active" : "Inactive"));
                        System.out.println();
                    }
                }
            } 
            
            else if (num == 4) {
                // Option to search for a student by ID
                System.out.println("Enter the student ID: ");
                int searchId = obj.nextInt();
               
                for (int i = 0; i < studentCount; i++) {
                    
                	if (students[i].getStudentId() == searchId) //Searches array to check if the student exists{
                    	//if they exist the code will print out their traits 
                        System.out.println(students[i].getFirstName()+" "+students[i].getLastName());
                        System.out.println("ID: " + students[i].getStudentId());
                        System.out.println("Level: " + students[i].getLevel());
                        System.out.println("Status: " + (students[i].isActive() ? "Active" : "Inactive"));
                    }
                }
             
        	
        	else if (num == 0) {
                // Option to exit the system
                exit = true;
            } 
        	//letting the user know that their input is not valid 
        	else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (!exit);
	}
}

class theStudent {
	//Variables of the theStudent class
    private int studentId;
    private String firstName;
    private String lastName;
    private String level;
    private boolean active;
    
    //Constructor that takes in different attributes and sets them to the previous variables  
    public theStudent(String firstName, String lastName, String level, boolean active) {
        Random rand = new Random();
        // we use "this" for scope
        this.studentId = rand.nextInt(100); // Generate a random ID
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.active = active;
    }

    // Getters and setters for student attributes
    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLevel() {
        return level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}