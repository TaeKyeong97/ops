package ops.Question.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

public class QuestionDeleteService {
	public boolean questionNo(int q_no) throws Exception {
		boolean isSuccess = false;
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		isSuccess = qd.isQuestionNo(q_no);
		close(con);
		return isSuccess;
		
	}
	public boolean deleteQuestion(int q_no) throws Exception{
		boolean deleteSuccess = false;
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		int x = qd.deleteQuestion(q_no);
		if(x>0){
			commit(con);
			deleteSuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return deleteSuccess;
	}
}
