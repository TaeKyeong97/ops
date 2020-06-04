package ops.member;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
//로그인 처리페이지
public class LoginProAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		String kind=request.getParameter("kind");	//회원 종류 기업,일반
		String userID=request.getParameter("id");
		String userPW=request.getParameter("pw");
		String redirectNext=null;
		if(request.getParameter("URL")!=null&&redirectNext!="") {
			redirectNext=request.getParameter("URL");
		}
		System.out.println(redirectNext);
		//로그인 처리
		if(kind.equals("user")) {
			LoginProService lps=new LoginProService();
			int state=lps.loginUserProService(userID, userPW);
			if(state>0) {
				HttpSession session=request.getSession();
				session.setAttribute("userID", userID);
				if(redirectNext!=null&&redirectNext!="") {
					forward=new ActionForward(redirectNext,true);
				}else {
					forward=new ActionForward("../ops/main",true);
				}				
			}else{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out= response.getWriter();
				out.println("<script>");
				out.println("alert('아이디 또는 페스워드가 일치 하지 않습니다.')");
				out.println("history.back();");
				out.println("</script>");
			}
		}else {
			LoginProService lps=new LoginProService();
			int state=lps.loginCorpProService(userID, userPW);
			if(state>0) {
				HttpSession session=request.getSession();
				session.setAttribute("emID", userID);
				session.setAttribute("EM_id", userID);
				if(redirectNext!=null&&redirectNext!="") {
					forward=new ActionForward(redirectNext,true);
				}else {
					forward=new ActionForward("../ops/main",true);
				}
			}else{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out= response.getWriter();
				out.println("<script>");
				out.println("alert('아이디 또는 페스워드가 일치 하지 않습니다.')");
				out.println("history.back();");
				out.println("</script>");
			}
		}
		
		return forward;
	}
}
