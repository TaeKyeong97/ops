package ops.Question.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Question.Beans.Question;

public class QuestionModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QuestionDetailService qds = new QuestionDetailService();
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		Question q = qds.getQuestion(q_no);
		request.setAttribute("q",q);
		ActionForward forward = new ActionForward("questionModify.jsp", false);
		return forward;
		
	}
}
