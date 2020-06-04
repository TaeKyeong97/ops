package ops.Question.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.Question.Beans.Question;

public class QuestionWriteService {
	public boolean insertQuestion(Question q) {
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		boolean isSuccess = false;
		int x = qd.insertQuestion(q);
		if(x>0) {
			commit(con);
			isSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isSuccess;
	}
}
