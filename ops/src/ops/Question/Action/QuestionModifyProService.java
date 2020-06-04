package ops.Question.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.Question.Beans.Question;


public class QuestionModifyProService {
	public boolean QuestionNo(int q_no) throws Exception {
		boolean questionNo = false;
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		questionNo = qd.isQuestionNo(q_no);
		close(con);
		return questionNo;
		
	}
	public boolean modifyQuestion(Question detail) throws Exception {
		
		boolean ModifySuccess = false;
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		int updateSuccess = qd.updateQuestion(detail);
		if(updateSuccess > 0){
			commit(con);
			ModifySuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return ModifySuccess;
	
	}
}
