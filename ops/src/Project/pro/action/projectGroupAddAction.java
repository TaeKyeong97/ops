package Project.pro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;

public class projectGroupAddAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) {
		ActionForward forward=null;
		String pj_no=request.getParameter("pj_no");
		String pjg_no=request.getParameter("pjg_no");
		if(request.getParameter("c_userID")!=null) {
		String c_userID[]=request.getParameter("c_userID").split(",");

			//프로젝트 그웁 인원 추가
			projectGroupAddService pjgas=new projectGroupAddService();
			int ppas=pjgas.ProjectPreAddService(c_userID, Integer.parseInt(pj_no),Integer.parseInt(pjg_no));
		}
		forward=new ActionForward("project.op?pj_no="+pj_no,true);
		
		return forward;
	}
}
