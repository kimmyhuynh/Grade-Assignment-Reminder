				/*********************************************
            				Author: Kimmy Huynh
            				https://github.com/kimmyhuynh
              				7kimmy.huynh@gmail.com
 				*********************************************/
public class Exam {
	private String examDate;
	private String examVenue;


	/*==========================================
	 This constructor gets called when the user
	 enters in details about the exam date and
	 exam venue.
	 ===========================================*/
	public Exam(String examDate, String examVenue) {
		this.examDate = examDate;
		this.examVenue = examVenue;
	}
	public String getExamDate() { return examDate; }
	public String getExamVenue() { return examVenue; }
}