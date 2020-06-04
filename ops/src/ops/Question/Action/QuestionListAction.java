package ops.Question.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Question.Beans.Question;

public class QuestionListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		QuestionListService qls = new QuestionListService();
		ArrayList<Question> questionList = qls.getQuestionList();
		request.setAttribute("questionList", questionList);
		forward = new ActionForward("questionList.jsp",false);
		return forward;
	}
}
