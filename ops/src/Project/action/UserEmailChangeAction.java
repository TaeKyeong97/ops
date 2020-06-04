package Project.action;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;
public class UserEmailChangeAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		Connection conn=null;
		HttpSession session=request.getSession();
		String EM_id=(String)session.getAttribute("EM_id");
		String Email=request.getParameter("email");
		String emailChange=request.getParameter("emailChange");
		String pw=request.getParameter("password");
		
		UserEmailChangeService uecs=new UserEmailChangeService();
		int state=uecs.userInfoChange(EM_id, Email, emailChange, pw, "emailChange");
		if(state>0) {
			forward=new ActionForward("infoChange.ops",true);
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 또는 패스워드를 확인 해주세요')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
