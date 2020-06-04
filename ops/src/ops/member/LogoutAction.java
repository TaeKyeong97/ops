package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;

//로그아웃 엑션
public class LogoutAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../ops/main",true);
		HttpSession session=request.getSession();
		session.invalidate();
		
		return forward;
	}
}
