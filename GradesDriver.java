				/*********************************************
            				Author: Kimmy Huynh
            				https://github.com/kimmyhuynh
              				7kimmy.huynh@gmail.com
 				*********************************************/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class GradesDriver {
	private Scanner keyboard = new Scanner(System.in);
	private ArrayList<Subject> subjectsAdded = new ArrayList<>();
	private ArrayList<Exam> examsAdded = new ArrayList<>();
	public static void main(String[] args) {
		GradesDriver gd = new GradesDriver();
		gd.run();
	}

	public enum displayOptions { D_SUBJECTS, D_DUEDATES, D_AVERAGE, D_REMOVE }
	public enum addOptions { A_SUBJECTS, A_DUEDATES, A_GRADE, A_EXAMVENUE, A_EXAMDATE, A_ASSIGNMENT }
	public enum mainMenu { SUBJECT_OPTIONS, DISPLAY_OPTIONS, EXIT }

	public void run() {
		int choice = 0;
		try {
			while(choice != 4) {
				mainDisplayMenu();
				choice = keyboard.nextInt();
				processChoice(choice);
			}
		} catch (InputMismatchException e) {
			System.err.println("Error: Invalid input. Please try again");
		}
	}

	public void runRemove() {
		int choice = -1;
		while(choice != 6) {
			removeOptionsMenu();
			choice = keyboard.nextInt();
			keyboard.nextLine();
			processRemoveOptions(choice);
		}
	}

	public void runSubject() {
		int choice = -1;
		while(choice != 5) {
			addOptionsMenu();
			choice = keyboard.nextInt();
			keyboard.nextLine();
			processAddOptionsSubject(choice);
		}
	}

	public void processAddOptionsSubject(int choice) {
		switch(choice) {
			case 1:
			addSubject();
			break;
			case 2:
			addDueDateForAss();
			break;
			case 3:
			//addExamDetails();
			break;
			case 4:
			break;
			case 5:
			break;
			default: 
			System.err.println("Error: Invalid choice.");
		}
	}

	public void processRemoveOptions(int choice) {
		switch(choice) {
			case 1:
			removeSubject();
			break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			break;
			default:
			System.err.println("Error: Invalid choice.");
		}
	} 

	public void runDisplay() {
		int choice = -1;
		while(choice != 4) {
			displayOptionsMenu();
			choice = keyboard.nextInt();
			keyboard.nextLine();
			processDisplayOptions(choice);
		}
	}
	public void processDisplayOptions(int choice) {
		switch(choice) {
			case 1:
			displaySubjects();
			break;
			case 2:
			displayAllDueDates();
		}
	}
	public void processChoice(int choice) {
		switch(choice) {
			case 1:
			runSubject();
			break;
			case 2:
			runDisplay();
			break;
			case 3:
			runRemove();
	        break;
			case 4:
			System.out.println("Exiting program...");
			break;
			default:
			System.err.println("Error: Invalid choice. Please try again");
			break;

		}
	}
	//This is the menu that the user first sees. The user may select one of the
	//following options to go into another menu.
	public void mainDisplayMenu(){
		System.out.println("\t\t======================");
		System.out.println("\t\t" + "      GRADES MENU");
		System.out.println("\t\t======================");
		System.out.println("1. Subject Options");
		System.out.println("2. Display Options");
		System.out.println("3. Remove Options");
		System.out.println("4. Exit");
		System.out.print("Select from the following: ");

	}
	public void displayOptionsMenu() {
		System.out.println("\t\t=====================");
		System.out.println("\t\t" + "    DISPLAY OPTIONS");
		System.out.println("\t\t=====================");
		System.out.println("1. Display Subjects");
		System.out.println("2. Display All Due Dates");
		System.out.println("3. Display Average");
		System.out.println("4. Exit");
		System.out.print("Select from the following: ");
	}

	public void addOptionsMenu() {
		System.out.println("\t\t=====================");
		System.out.println("\t\t" + "     ADD OPTIONS");
		System.out.println("\t\t=====================");
		System.out.println("1. Add a subject");
		System.out.println("2. Add a due date for an assignment");
		System.out.println("3. Add exam details");
		System.out.println("4. Add grade");
		System.out.println("5. Exit");
		System.out.print("Select from the following: ");
	}
	//should I have a change options menu or keep the delete and make
	//the user manually enter it in again?
	public void changeOptionsMenu() {

	}

	public void removeOptionsMenu() {
		System.out.println("\t\t===================");
		System.out.println("\t\tREMOVE OPTIONS");
		System.out.println("\t\t===================");
		System.out.println("1. Remove a subject");
		System.out.println("2. Remove an assignment");
		System.out.println("3. Remove a due date for an assignment");
		System.out.println("4. Remove an exam venue");
		System.out.println("5. Remove an exam date");
		System.out.println("6. Remove a grade");
		System.out.print("Select from the following: ");
	}
												/*==================================
														ALL REMOVE FUNCTIONS
	 											 ==================================*/
	 public void removeSubject() {
	 	System.out.println("\t\t============================");
	 	System.out.println("\t\tCURRENTLY IN REMOVE SUBJECT");
	 	System.out.println("\t\t============================");
	 	System.out.print("Please enter in the subject you wish to remove: ");
	 	String subject = keyboard.nextLine().toUpperCase();
	 	boolean exists = false;
	 	for(int i = 0; i < subjectsAdded.size() && !exists; i++) {
	 		if(subjectsAdded.get(i).getSubjectName().equals(subject)) {
	 			exists = true;
	 			System.out.println("Error: " + subject + " does not exist. Please remove a subject that already exists.");
	 		}
	 	}
	 }											 
												/*====================================
         												ALL THE ADD FUNCTIONS
 												=====================================*/

	/*==============================================================
	  This method asks the user for the name/code of the subject,
	  and checks if an existing subject already exists. If it does
	  it will throw an error. Otherwise it will continue asking for
	  the rest of the details required and add it into the ArrayList
	  ==============================================================*/
	  //logic is flawed
	public void addSubject() {
		System.out.println("\f\t\t========================");
		System.out.println("\t\tCURRENTLY IN ADD SUBJECT");
		System.out.println("\t\t========================");
		boolean elective = true;
		boolean exists = false;
		System.out.print("Enter name or code of subject: ");
		String subject = keyboard.nextLine().toUpperCase();
		for(int i = 0; i < subjectsAdded.size() && !exists; i++) {
			if(subjectsAdded.get(i).getSubjectName().equals(subject)) {
				exists = true;	
			}

		}
		if(exists) {
			System.out.println("Error: " + "\"subject\"" + " already exists.");
		} else {
			System.out.print("How many assignments are in " + subject + "? ");
			int assignments = keyboard.nextInt();
			System.out.print("Is this subject a core? (true or false) ");
			boolean core = keyboard.nextBoolean();
			if(core) {
				elective = false;
			}
			Subject subject1 = new Subject(subject, assignments, core, elective);
			subjectsAdded.add(subject1);
		}
	}

	/*==========================================================
	  This method is when the user wants to be able to enter
	  the due date for a particular assignment and a particular
	  subject. If the subject doesn't exist, it will notify the
	  user thst the subject doesn't exist.
	  ==========================================================*/
	public void addDueDateForAss() {
		System.out.println("\t\t==========================");
		System.out.println("\t\tCURRENTLY IN ADD DUE DATE");
		System.out.println("\t\t==========================");
		boolean exists = false;
		System.out.print("Please enter the subject required for this: ");
		String subject = keyboard.nextLine();
		int index = -1;
		for(int i = 0; i < subjectsAdded.size() && !exists; i++) {
			if(subjectsAdded.get(i).getSubjectName().equalsIgnoreCase(subject)) {
				exists = true;
				index = i;
			}
		}
		if(!exists) {
			System.out.println("Error: Subject does not exist. Please add a subject before entering the due date.");
		} else {
			System.out.print("Please enter the assignment name/no: ");
			String assignmentName = keyboard.nextLine();
			System.out.print("Please enter a due date: ");
			String date = keyboard.nextLine();
			Assignment assignment1 = new Assignment(assignmentName, date);
			subjectsAdded.get(index).addAssignment(assignment1);
		}
	}
	/*====================================================
	  This method is for when the user wants to enter
	  the exam details for a particular subject. The
	  method will ask the user to enter a subject,
	  if the subject doesn't exist it will notify 
	  the user. Otherwise method will proceed and ask
	  the details regarding the subject's exam and add it
	  in the ArrayList.
	  ====================================================*/
	public void addExamDetails() {
		boolean exists = false;
		System.out.print("Enter the subject for this exam period: ");
		String subject = keyboard.nextLine();
		for(int i = 0; i < subjectsAdded.size() && !exists; i++) {
			if(subjectsAdded.get(i).getSubjectName().equals(subject)) {
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("Error: Subject does not exist. Please add a subject before entering the exam details.");
		} else {
			System.out.print("Enter the exam date: ");
			String examDate = keyboard.nextLine();
			System.out.print("Enter the exam venue: ");
			String examVenue = keyboard.nextLine();
			Exam exam1 = new Exam(examDate, examVenue);
			examsAdded.add(exam1);
		}
	}

	public void addGrade() {
		System.out.println("\t\t====================");
		System.out.println("\tCURRENTLY IN ADD GRADE");
		System.out.println("\t\t====================");
		System.out.print("Enter a subject: ");
		String subject = keyboard.nextLine();
		boolean exists = false;
		for(int i = 0; i < subjectsAdded.size() && !exists; i++) {
			if(subjectsAdded.get(i).getSubjectName().equals(subject)) {
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("Error: Subject does not exist. Please add a subject before entering the grade details.");
		} else {
			System.out.print("Enter grade (integers) for " + subject + ":");
			int grade = keyboard.nextInt();
		}

	}

													/*============================================
	           													ALL THE DISPLAY METHODS
	 												============================================*/
	           
	/*========================================
	  This method displays all of the subjects
	  entered by the user
	  ========================================*/
	public void displaySubjects() {
		System.out.println("\t\t================");
		System.out.println("\t\tSUBJECTS ENTERED");
		System.out.println("\t\t================");
		if(subjectsAdded.size() == 0) {
			System.err.println("There are no subjects to display.");
		}
		else {
			for(Subject s : subjectsAdded) {
				System.out.println(s.getSubjectName());
			}
		}
	}
	public void displayAllDueDates() {
		System.out.println("\t\t=========");
		System.out.println("\t\tDUE DATES");
		System.out.println("\t\t=========");
		for(Subject s : subjectsAdded) {
			System.out.println("Subject: " + s.getSubjectName());
			String temp = s.displayAssignments();
			if(temp.isEmpty()) {
				System.err.println("Error: There are no assignments recorded");
			} else {
				System.out.println(temp);
			}
			System.out.println();
		}
	}
	public void displayExamDetails() {
		System.out.println("\t\t=============");
		System.out.println("\tEXAM DETAILS");
		System.out.println("\t\t=============");
		for(Exam e : examsAdded) {
			//how can it can display an exam for a particular subject which is clear for the user
			System.out.println(e.getExamDate() + ", " + e.getExamVenue());
		}
	}
}