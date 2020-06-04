package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;
//프로젝트 그룹별 팀장 설정
public class pgAdminSettingProAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		int pjgNo=0;
		String pjg_admin=null;
		if(request.getParameter("pjg_no")!=null) {
			pjgNo=Integer.parseInt(request.getParameter("pjg_no"));
		}
		if(request.getParameter("pjg_admin")!=null) {
			pjg_admin=request.getParameter("pjg_admin");
		}
		pgAdminSettingService pass=new pgAdminSettingService();
		pass.pgAdminSettingPro(pjg_admin, pjgNo);
		return forward;
	}
}
