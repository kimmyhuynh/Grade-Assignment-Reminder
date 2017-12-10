				/*********************************************
            				Author: Kimmy Huynh
            				https://github.com/kimmyhuynh
              				7kimmy.huynh@gmail.com
 				*********************************************/
public class Assignment {
	private String assignmentName;
	private String dueDate;

	/*=========================================================
	  This constructor gets called when the user has previously
	  already entered a subject and wants to enter the subject's
	  assignment details.
	  =========================================================*/
	public Assignment(String assignmentName, String dueDate) {
		this.assignmentName = assignmentName;
		this.dueDate = dueDate;
	}

	public String getDueDate() { return dueDate; }
	public String getAssignmentName() { return assignmentName; }

}