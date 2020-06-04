package Project.simple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;

public class NavAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("A", "AB");
		
		ActionForward forward=new ActionForward("nav.jsp",false);
		return forward;
	}

}
