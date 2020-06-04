package Project.pro.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.ProjectGroupProject;
import comm.Action;
import comm.ActionForward;

public class ProjectGroupAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		//그룹 프로젝트 생성을위한 그룹 프로젝트 페이지에 번호값 넘기기
		String pj_no=request.getParameter("pj_no");
		String gp_no=request.getParameter("gp_no");
		request.setAttribute("pj_no",pj_no);
		request.setAttribute("pjg_no",gp_no);
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		
		if(myId!=null) {
			System.out.println(myId);
			//그룹별 프로젝트 리스트 조회
			ProjectGroupService pgs=new ProjectGroupService();
			ArrayList<ProjectGroupProject> pgplist=pgs.ProjectGroupListService(Integer.parseInt(gp_no), myId);
			request.setAttribute("pgplist",pgplist);
		}
		
		forward =new ActionForward("group.jsp",false);
		
		return forward;
	}
}
