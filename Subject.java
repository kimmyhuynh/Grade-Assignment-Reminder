				/*********************************************
            				Author: Kimmy Huynh
            				https://github.com/kimmyhuynh
              				7kimmy.huynh@gmail.com
 				*********************************************/         
import java.util.ArrayList;
public class Subject {
	private String subjectName;
	private int howManyAssignments;
	private boolean isCore;
	private boolean isElective;
	private ArrayList<Assignment> assignmentsAdded = new ArrayList<>();

	/* =====================================================================================
	   This constructor gets called when the user is just providing the subject code/name,
	   how many assignments are given in the subject and whether it is a core or an elective.
	   =====================================================================================*/ 
	public Subject(String subjectName, int howManyAssignments, boolean isCore, boolean isElective) {
		this.subjectName = subjectName;
		this.howManyAssignments = howManyAssignments;
		this.isCore = isCore;
		this.isElective = isElective;
	}
	public String getSubjectName() { return subjectName; }
	public void addAssignment(Assignment a) {
		assignmentsAdded.add(a);
	}
	public String displayAssignments() {
		String result = "";
		for(Assignment a : assignmentsAdded) {
			result += a.getDueDate() + " " + a.getAssignmentName() + "\n";
		}
		return result;
	}
}