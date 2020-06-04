package ops.Question.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

public class QuestionDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		QuestionDeleteService qdp = new QuestionDeleteService();
		ActionForward forward = null;
		boolean DeleteSuccess = qdp.deleteQuestion(q_no);
		if(!DeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward("questionList.no", false);
		}
		return forward;
	}

}
