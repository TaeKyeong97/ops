package Project.simple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class ProjectLogoutAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();		
		ActionForward forward=new ActionForward("../index.ops",true);
		return forward;
	}
}
