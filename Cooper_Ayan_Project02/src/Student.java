/*
 * ICSI 201 Project 2: Students GPA
 * State University of New York, University at Albany
 * Developed by Ayan Cooper, CS Major, Class of 2026
 * 
 * This program reads from the text file Roster.txt, a file that contains a list of students with their GPAs. The class
 * DriverGPA works with the class Student to allow users to read and choose from a menu of options. These options consist of
 * finding the student with the lowest GPA, finding the student with the highest GPA, calculating the average GPA, displaying the 
 * entire roster, and quitting the program. The program will run over and over until the user chooses to quit the program.
 * 
 * The Student class holds various methods that the class DriverGPA class will call from. These methods will display the first name, 
 * last name, and GPA of each student.
 */

public class Student { // Student class that identifies the first name, last name, and GPA of each student.
	private String firstName; // First name of each student.
	private String lastName; // Last name of each student.
	private double valueGPA; // GPA of each student.
	
	/**
	 * The method Student is the constructor method of the Student class. This is what DriverGPA will use to create various 
	 * objects in the program of student records (first name, last name, GPA).
	 * @param fn // The student's first name.
	 * @param ln // The student's last name.
	 * @param vGPA // The student's GPA.
	 */
	public Student(String fn, String ln, double vGPA) {
		this.firstName = fn; // Sets fn as the first name of the student.
		this.lastName = ln; // Sets ln as the last name of the student.
		this.valueGPA = vGPA; // Sets vGPA as the GPA of the student.
	}
	
	/**
	 * The method getFirstName gets the first name of the student.
	 * @return Returns the first name of the student.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * The method getLastName gets the last name of the student.
	 * @return Returns the last name of the student.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * The method getGPA gets the GPA of the student.
	 * @return Returns the GPA of the student.
	 */
	public double getGPA() {
		return valueGPA;
	}
	
	/**
	 * The method toString prints out the first name, last name, and GPA of the student when a Student object is created 
	 * and needs to be displayed.
	 */
	public String toString() {
		return firstName + " " + lastName + " " + valueGPA;
	}
}
