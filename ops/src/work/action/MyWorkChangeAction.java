package work.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Work;
import comm.Action;
import comm.ActionForward;

public class MyWorkChangeAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//내 알림 수정하기
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String wo_noString=request.getParameter("wo_no");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		
		int wo_no=0;
		if(wo_noString!=null) {
			wo_no=Integer.parseInt(wo_noString);
		}
		Work work=new Work();
		work.setWo_title(title);
		work.setWo_content(content);
		work.setWo_StratDate(startDate);
		work.setWo_EndDate(endDate);
		
		MyWorkChangeService mcs=new MyWorkChangeService();
		mcs.myWorkChangeService(wo_no, myId, work);
		
		
		forward = new ActionForward("index.ops",true);
		return forward;
	}

}
