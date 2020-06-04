package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
//회원정보 수정 처리페이지
public class MyInfoChangeProAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		String pw=request.getParameter("pw");
		MyInfoChangeProService mps=new MyInfoChangeProService();
		mps.myInfoChangeProService(pw, userID);
		
		forward=new ActionForward("../ops/main",true);
		return forward;		
	}

}
