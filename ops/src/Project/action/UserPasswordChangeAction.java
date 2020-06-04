package Project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class UserPasswordChangeAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("EM_id");
		String pwChange=request.getParameter("pwChange");
		String pw=request.getParameter("password");
		String Email=request.getParameter("Email");
		String change="pwChange";
		
		
		UserPasswordChangeService upchs=new UserPasswordChangeService();
		int state=upchs.userPasswrodChange(id, Email, pwChange, pw, change);
		
		if(state>0) {
			
			forward=new ActionForward("infoChange.ops",true);
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치 하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}
}
