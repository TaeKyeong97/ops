package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Member;
import comm.Action;
import comm.ActionForward;

public class ProjectUserInfoAction implements Action{
	//사용자 정보 가져오기
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("EM_id");
		ProjectUserInfoService pjui=new ProjectUserInfoService();
		Member list=pjui.userInfoService(id);
		
		ActionForward forward =new ActionForward("pj.jsp",false);
		return forward;
	}
}
