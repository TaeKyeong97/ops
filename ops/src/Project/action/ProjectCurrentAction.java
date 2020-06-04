package Project.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.ProjectBean;
import comm.Action;
import comm.ActionForward;

public class ProjectCurrentAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//참여중인 프로젝트현황
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myid=(String) session.getAttribute("EM_id");
		ProjectCurrentService pcs =new ProjectCurrentService();
		ArrayList<ProjectBean> pb=pcs.selectMyProjectService(myid);
		request.setAttribute("pb", pb);
		//승인대기중인 프로젝트
		ArrayList<ProjectBean> pbAppl=pcs.selectMyProjectApprovalService(myid);
		request.setAttribute("pbAppl", pbAppl);
		
		forward=new ActionForward("pjCurrent.jsp",false);
		
		return forward; 
	}
}
