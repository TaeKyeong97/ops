package work.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project.beans.Work;
import comm.Action;
import comm.ActionForward;

public class WorkViewAction implements Action {
	//업무 상세 보기
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		String ws_noString=request.getParameter("ws_no");
		int ws_no=0;
		if(ws_noString!=null) {
			ws_no=Integer.parseInt(ws_noString);
		}
		WorkViewService wvs=new WorkViewService();
		Work work=wvs.workviewService(ws_no);
		request.setAttribute("work", work);
		
		forward = new ActionForward("workView.jsp",false); 
		return forward;
	}
}
