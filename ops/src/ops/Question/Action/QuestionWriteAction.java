package ops.Question.Action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Question.Beans.Question;


public class QuestionWriteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		QuestionWriteService qws = new QuestionWriteService();
		Question q = new Question();
		q.setQ_title(request.getParameter("title"));
		q.setQ_content(request.getParameter("content"));
		q.setQ_date(new Timestamp(System.currentTimeMillis()));
		qws.insertQuestion(q);
		
		forward = new ActionForward("questionList.no", true);
		return forward;
	}
}

