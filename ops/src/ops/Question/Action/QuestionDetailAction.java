package ops.Question.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Question.Beans.Question;

public class QuestionDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		Question detail = null;
		Connection con = getConnection();
		QuestionData qd = QuestionData.getInstance();
		qd.setConnection(con);
		detail = qd.selectQuestionDetail(q_no);
		close(con);
		
		request.setAttribute("detail", detail);
		ActionForward forward = new ActionForward("questionDetail.jsp",false);
		return forward;
	}
}
