package Project.simple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.action.ProjectUserInfoService;
import Project.beans.Member;
import comm.Action;
import comm.ActionForward;

public class ProjectHeadAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) {
		ActionForward forward=null;	
		
		
		forward=new ActionForward("OneFolderHead.jsp",false);
		return forward;
	}
}
