package Project.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project.beans.ProjectBean;
import Project.pro.action.ProjectGroupPreInfoService;
import comm.Action;
import comm.ActionForward;
//프로젝트 그룹별 팀장 설정
public class pgAdminSettingAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward("groupAdminSetting.jsp",false);
		
		String pjg_no=null;
		if(request.getParameter("pjg_no")!=null) {
			pjg_no=request.getParameter("pjg_no");
		}
		//현재 참여중인 프로젝트 인원 정보 가져오기
		ProjectGroupPreInfoService pjgpis=new ProjectGroupPreInfoService();
		ArrayList<ProjectBean> pjgpi=pjgpis.projectGroupPeInfo(pjg_no);
		
		
		request.setAttribute("pjgpi", pjgpi);
		return forward;
	}
}
