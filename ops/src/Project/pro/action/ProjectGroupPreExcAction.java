package Project.pro.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project.beans.ProjectBean;
import comm.Action;
import comm.ActionForward;

public class ProjectGroupPreExcAction  implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//특정프로젝트 그룹 참여자를 제외한 프로젝트 참여인원
		ActionForward forward=null;
		String pj_no =request.getParameter("pj_no");
		String pjg_no =request.getParameter("pjg_no");
		
		ProjectGroupPreExcService pjgpes=new ProjectGroupPreExcService();
		ArrayList<ProjectBean> pjgpesList=pjgpes.ProjectGroupPreExc(Integer.parseInt(pj_no), Integer.parseInt(pjg_no));
		request.setAttribute("pjgpesList", pjgpesList);
		
		
		//프로젝트 그룹 참여 인원이  없다면 검색이 되지 않아 추가함 (그룹 참여인원이 없다면 프로젝트 참여인원 모두 검색해 가져오기
		ArrayList<ProjectBean> pjgpesListAll=pjgpes.ProjectGroupPreAll(pj_no);
		request.setAttribute("pjgpesListAll", pjgpesListAll);
		
		forward=new ActionForward("projectGroupPeExc.jsp",false);
		return forward;
	}

}
