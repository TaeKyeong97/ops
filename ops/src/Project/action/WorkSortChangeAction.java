package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class WorkSortChangeAction implements Action {
	//업무 구분 변경(신규 업무 내업무 위치)
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String pj_noString=request.getParameter("pj_no");
		int pj_no=0;
		if(pj_noString!=null) {
			pj_no=Integer.parseInt(pj_noString);
		}
		
		String myWork=request.getParameter("myWork");		//내업무
		String noWork=request.getParameter("nowWork");	//신규업무
		String myWorkArray[] = null;
		String noWorkArray[] = null;
		if(myWork!=null) {
			myWorkArray=myWork.split(",");
		}
		if(myWork!=null) {
			noWorkArray=noWork.split(",");
		}
		WorkSortChangeService wscs=new WorkSortChangeService();
		wscs.workSortChangeService(myId, pj_no,myWorkArray,noWorkArray);
		
		
		
		return forward;
	}
}
