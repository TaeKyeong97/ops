package Project.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project.beans.ProjectGroupBean;
import comm.Action;
import comm.ActionForward;
//조직도 가져오기
public class OrgaChartAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward("orgchart/orgchat.jsp",false);
		int pjNo=0;
		int pjNoFk=0;
		if(request.getParameter("pjNo")!=null) {
			pjNo=Integer.parseInt(request.getParameter("pjNo"));
		}
		if(request.getParameter("pjNoFk")!=null) {
			pjNoFk=Integer.parseInt(request.getParameter("pjNoFk"));
		}
		
		OrgaChartService ocs=new OrgaChartService();
		//프로젝트 생성자 정보 가져오기
		String adminName=ocs.searchProjectAdmin(pjNo);
		//그룹별 관리자 정보
		ArrayList<ProjectGroupBean> gpAdminName=ocs.searchProjectGAdmin(pjNo);
		//그룹별 팀원 정보 가져오기
		ArrayList<ProjectGroupBean> gpUserName=ocs.searchProjectGUser(pjNo);
		
		request.setAttribute("adminName", adminName);
		request.setAttribute("gpAdminName", gpAdminName);
		request.setAttribute("gpUserName", gpUserName);
		return forward;
	}
}
