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
 * The DriverGPA class holds all of the options for the user to choose from. Once an option is chosen, DriverGPA will execute 
 * that method corresponding with the choice.
 */

import java.util.Scanner; // Allows program to use the Scanner class.
import java.io.*; // Allows this class to read and write data from another file (Roster.txt).

public class DriverGPA { // Driver class that runs various methods for the Students GPA program.
	
	public static void main(String[] args)throws IOException { // Main method to run program.
		
		// file and input are used to read from the text file Roster.txt.
		FileReader file = new FileReader("Roster.txt");
	    BufferedReader input = new BufferedReader(file);  
	   
		//Variables.
		String firstName; // First name of each student.
		String lastName; // Last name of each student.
		double GPA; // GPA of each student.
		String line = input.readLine(); // String variable used to read a line from the Roster.txt file.
		
		int choice; // User input value to select what the program outputs.
		Student[] roster = new Student[100]; // An array used to store up to 100 student records.
		int count = 0; // Counter used to count how many records of students there are (3 lines = 1 record).
		
		Scanner keyboard = new Scanner(System.in); // Scanner object to read user input.
		
		/**
		 * This while loop will read through the entire Roster.txt file until there are no more lines to read.
		 */
		while (line != null) { // Runs until there're no more lines in Roster.txt.
			firstName = line; // First line of a student record.
			lastName = input.readLine(); // Second line of a student record.
			GPA = Double.parseDouble(input.readLine()); // Third line of a student record; converts GPA into a double value.
			roster[count] = new Student(firstName, lastName, GPA); // Creates a new Student object.
			count++; // Counter increases based on number of student records.
			line = input.readLine(); // Reads lines from Roster.txt.
		}
		input.close();
		file.close();
		
		/**
		 * These three lines tell the purpose of the program.
		 */
		System.out.println("This program processes the file with students' GPAs.");
		System.out.println("");
		System.out.println("");
		
		/**
		 * This do/while loop will displays a list of choices for the user to choose from. It will run over and over 
		 * until the user chooses to quit the program. Other than quitting the program, the following options 
		 * consist of finding the lowest GPA, finding the highest GPA, calculating the average GPA, 
		 * and displaying the entire roster.
		 */
		do {
			printMenu(); // Calls the printMenu method
			choice = keyboard.nextInt(); // Takes user input for choice
			
			/**
			 * If the user chooses option 1, the program will identify and print the student with the lowest GPA.
			 */
			switch (choice) {
			case 1:
				lowestGPA(roster, count); // Calls the lowestGPA method
				break; // Ensures the method is only called once
			/**
			 * If the user chooses option 2, the program will identify and print the student with the highest GPA.
			 */
			case 2:
				highestGPA(roster, count); // Calls the highestGPA method
				break; // Ensures the method is only called once
			/**
			 * If the user chooses option 3, the program will calculate and print the average student GPA.
			 */
			case 3:
				averageGPA(roster, count); // Calls the averageGPA method
				break; // Ensures the method is only called once
			/**
			 * If the user chooses option 4, the program will print the entire student roster.
			 */
			case 4:
				fullRoster(roster, count); // Calls the fullRoster method
				break; // Ensures the method is only called once
			/**
			 * If the user chooses option 5, the program will stop running.
			 */
			case 5:
				break; // Quits the program
			}
		} while (choice != 5); // Program continuously runs as long as the user hasn't chosen option 5.
	}
	
	/**
	 * The method printMenu prints out a menu for the user to read and choose from. The program requires 
	 * user input, so this method displays said menu for the user to choose from. The options are to 
	 * display the student with the lowest GPA, display the student with the highest GPA, calculate the 
	 * average GPA, display the entire roster, and quit the program.
	 */
	public static void printMenu() {
		System.out.println("Enter the number that corresponds with the option."
				+ " What is your choice?");
		System.out.println("	1) Find lowest GPA");
		System.out.println("	2) Find highest GPA");
		System.out.println("	3) Calculate Average GPA");
		System.out.println("	4) Print entire roster");
		System.out.println("	5) Quit program");
	}
	
	/**
	 * The method lowestGPA identifies the student in the text file Roster.txt with the lowest GPA.
	 * @param r The Student array (roster) that has the entire student roster.
	 * @param count The number of student records in the text file Roster.txt.
	 */
	public static void lowestGPA(Student[] r, int count) {
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("The lowest GPA is ");
		
		double minValue = r[0].getGPA(); // Used to identify lowest GPA in the student roster (initially sets the lowest GPA as 
										 // the first GPA in the roster).
		int index = 0; // Identifies what index in the array has the lowest GPA (initially sets the first index as the student 
					   // with the lowest GPA).
		
		/**
		 * This for loop runs through the entire student roster, searching for the student with the lowest GPA. If any 
		 * student record happens to be lower than the first student record, the loop sets minValue to that GPA and sets 
		 * index to that student record.
		 */
		for (int i = 0; i < count; i++) { // Runs as as many times as the number of student records.
			if (r[i].getGPA() < minValue) { // If any GPA happens to be lower than the first: 
				minValue = r[i].getGPA(); // Sets the minValue to the lowest GPA.
				index = i; // Sets the index to the student record with the lowest GPA.
			}
		}
		System.out.println(r[index].toString()); // Calls the toString method from the Student class
												 // to print the student with the lowest GPA.
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
	}
	
	/**
	 * The method highestGPA identifies the student in the text file Roster.txt with the highest GPA.
	 * @param r The Student array (roster) that has the entire student roster.
	 * @param count The number of student records in the text file Roster.txt.
	 */
	public static void highestGPA(Student[] r, int count) {
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("The highest GPA is ");
		
		double maxValue = r[0].getGPA(); // Used to identify highest GPA in the student roster (initially sets the highest GPA as 
										 // the first GPA in the roster).
		int index = 0; // Identifies what index in the array has the highest GPA (initially sets the first index as the student 
					   // with the highest GPA).

		/**
		 * This for loop runs through the entire student roster, searching for the student with the highest GPA. If any 
		 * student record happens to be higher than the first student record, the loop sets maxValue to that GPA and sets 
		 * index to that student record.
		 */
		for (int i = 0; i < count; i++) { // Runs as as many times as the number of student records.
			if (r[i].getGPA() > maxValue) { // If any GPA happens to be higher than the first: 
				maxValue = r[i].getGPA(); // Sets the maxValue to the highest GPA.
				index = i; // Sets the index to the student record with the highest GPA.
			}
		}
		System.out.println(r[index].toString()); // Calls the toString method from the Student class
												 // to print the student with the highest GPA.
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
	}
	
	/**
	 * The method averageGPA calculates the average student GPA from the text file Roster.txt.
	 * @param r The Student array (roster) that has the entire student roster.
	 * @param count The number of student records in the text file Roster.txt.
	 */
	public static void averageGPA(Student[] r, int count) {
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		double total = 0; // Initialized the total GPA as 0, until ran in the following for loop.
		
		/**
		 * This for loop adds up all of the GPAs in the student roster.
		 */
		for (int i = 0; i < count; i++) { // Runs as as many times as the number of student records.
			total += r[i].getGPA(); // Calls the getGPA method from the Student class to add up all of the student GPAs.
		}
		double average = total / (count); // Calculates the average GPA by dividing the total GPA by the amount of student records.
		System.out.printf("The average GPA is %.2f\n", average); // Prints the average GPA.
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
	}
	
	/**
	 * The method fullRoster displays the entire student roster from the text file Roster.txt.
	 * @param r The Student array (roster) that has the entire student roster.
	 * @param count The number of student records in the text file Roster.txt.
	 */
	public static void fullRoster(Student[] r, int count) {
		
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("The full roster: \n");
		
		/**
		 * This for loop prints out each student from the entire roster (first name, last name, and GPA) on a new line, with an
		 * empty line in between so it's easier to read.
		 */
		for (int i = 0; i < count; i++) { // Runs as as many times as the number of student records.
			System.out.println(r[i] +"\n");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
	}
}
