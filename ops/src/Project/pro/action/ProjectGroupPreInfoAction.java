package Project.pro.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project.beans.ProjectBean;
import comm.Action;
import comm.ActionForward;

public class ProjectGroupPreInfoAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
	//프로젝트 특정 그룹 참여 인원 가져오기
	ActionForward forward=null;
	String pjg_no=request.getParameter("pjg_no");
	ProjectGroupPreInfoService pjgpis=new ProjectGroupPreInfoService();
	ArrayList<ProjectBean> pjgpi=pjgpis.projectGroupPeInfo(pjg_no);
	request.setAttribute("pjgpi", pjgpi);
	
	forward =new ActionForward("projectGroup.jsp",false);

	return forward;
	}
}
