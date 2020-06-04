package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class projectMainSettingAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myid=(String)session.getAttribute("EM_id");
		String pj_no=request.getParameter("pj_no");
		projectMainSettingService pmss=new projectMainSettingService();
		pmss.projectMainSettingServices(myid, pj_no);
		
		forward = new ActionForward("pjCurrent.ops",true);
		
		
		return forward;
	}
}
