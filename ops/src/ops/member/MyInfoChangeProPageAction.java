package ops.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.member.beans.MemberBean;
//회원정보 수정 정보 입력 페이지
public class MyInfoChangeProPageAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		if(request.getAttribute("access")!=null) {
			String access=(String)request.getAttribute("access");
			if(access.equals("yes")){
				HttpSession session=request.getSession();
				String id=(String)session.getAttribute("userID");
				MyInfoChangeProPageService micps=new MyInfoChangeProPageService();
				MemberBean mb=micps.myInfoChangeProPageService(id);
				request.setAttribute("myInfo",mb);				
				forward=new ActionForward("../member/myInfoChangeProPage.jsp",false);
			}else {
				response.setContentType("text/html; charset=utf-8");			
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 접근입니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
		}else{
			response.setContentType("text/html; charset=utf-8");			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.-')");
			out.println("history.back()");
			out.println("</script>");
		}	
		return forward;	
		
	}

}
