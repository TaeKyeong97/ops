package ops.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

public class SearchPasswordAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			
		// 비밀번호 찾기
		ActionForward forward=null;
		String myId=request.getParameter("myId");
		String phone=request.getParameter("phone");
		SearchPasswordService sps=new SearchPasswordService();
		String password=sps.searchPasswordService(myId, phone);
		request.setAttribute("password",password);
		if(password!=null) {
			forward=new ActionForward("../login/FindPassword.jsp?loginCk=1",false);
		}else {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.write("<script>");
				out.write("alert('정보가 일치 하지 않습니다.');");
				out.write("history.back();");
				out.write("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return forward;
	}
}
