package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class ProjectApplSettingAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myid=(String)session.getAttribute("EM_id");
		String pj_no=request.getParameter("pj_no");
		String appl=request.getParameter("appl");
		
		ProjectApplSettingService pjss=new ProjectApplSettingService();
		pjss.ProjectApplSetting(myid, pj_no, appl);
		
		//forward=new ActionForward("",true); 비동기 통신이라 딸 ㅗ설정 x
		
		return forward;
	}
}
