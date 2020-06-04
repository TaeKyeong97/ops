package ops.Question.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import ops.Question.Beans.Question;

public class QuestionDetailService {
	public Question getQuestion(int q_no) throws Exception {
		Question q = null;
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		q = qd.selectQuestionDetail(q_no);
		close(con);
		
		return q;
	}
}
