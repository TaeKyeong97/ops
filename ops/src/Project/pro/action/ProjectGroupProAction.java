package Project.pro.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project.beans.ProjectGroupProject;
import comm.Action;
import comm.ActionForward;

public class ProjectGroupProAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//그룹 프로젝트 생성
		ActionForward forward=null;
		request.setCharacterEncoding("utf-8");
		String pjgp_title=request.getParameter("title");
		String pjgp_content=request.getParameter("subTitle");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		
		String pjgp_division=request.getParameter("division");
		String pjg_no=request.getParameter("pjg_no");
		String pj_no=request.getParameter("pj_no");
		
		ProjectGroupProject pgp=new ProjectGroupProject();
		pgp.setPjgp_title(pjgp_title);
		pgp.setPjgp_content(pjgp_content);
		pgp.setStartDate(startDate);
		pgp.setEndDate(endDate);
		pgp.setPjgp_date(new Timestamp(System.currentTimeMillis()));
		pgp.setPjgp_division(Integer.parseInt(pjgp_division));
		pgp.setPjg_no(Integer.parseInt(pjg_no));
		
		
		ProjectGroupProService pjgps=new ProjectGroupProService();
		pjgps.gorupProjectInsertService(pgp);
		
		
		forward=new ActionForward("project.op?pj_no="+pj_no,true);
		
		return forward;
	}
}
