package ops.Question.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Question.Beans.Question;

public class QuestionModifyProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QuestionModifyProService qmps = new QuestionModifyProService();
		ActionForward forward = null;
		boolean isSuccess = false;
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		Question q = new Question();
		boolean isQuestionNo = qmps.QuestionNo(q_no);
		if(!isQuestionNo){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('접근실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			q.setQ_no(q_no);
			q.setQ_title(request.getParameter("title"));
			q.setQ_content(request.getParameter("content"));	
			isQuestionNo = qmps.modifyQuestion(q);
			
			if(!isSuccess){
				forward = new ActionForward("questionList.no", false);
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패.');");
				out.println("history.back()");
				out.println("</script>");						
			}
		}
		return forward;
	}
}
