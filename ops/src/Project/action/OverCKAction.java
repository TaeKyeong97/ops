package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;

public class OverCKAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward("overCK.jsp",false);
		String id=request.getParameter("EM_id");
		
		
		OverCKService ocks=new OverCKService();
		int state=ocks.overCkService(id);
		request.setAttribute("idOver", state);

		
		return forward;
	}
}
