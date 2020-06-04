package ops.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
//회원 정보 수정
public class MyInfoChangePageAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		String userPW=request.getParameter("pw");
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		
		//비밀번호 일치 여부 확인
		MyInfoChangePageService micps=new MyInfoChangePageService();
		if(userPW!=null) {
			int state=micps.myInfoChangePageService(userID, userPW);
			if(state>0) {
				request.setAttribute("access","yes");
				forward =new ActionForward("myInfoChangeProPage",false);
			}else if(state==0){
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비정상적인 접근이 감지되었습니다.\\n정상 접근임에도 불구하고 지속된다면 관리자에게 문의하세요.')");
				out.println("history.back()");
				out.println("</script>");
				
			}else{
				response.setContentType("text/html; charset=utf-8");			
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호를 확인해 주세요.')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
		
		return forward;		
	}

}
