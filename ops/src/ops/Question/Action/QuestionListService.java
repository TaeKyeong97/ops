package ops.Question.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.Question.Beans.Question;

public class QuestionListService {
	public ArrayList<Question> getQuestionList() {
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		ArrayList<Question> questionList = qd.selectQuestionList();
		close(con);
		return questionList;
	}
	
}
