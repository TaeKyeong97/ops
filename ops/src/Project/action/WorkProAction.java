package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Work;
import comm.Action;
import comm.ActionForward;

public class WorkProAction implements Action{
	//알림생성
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =new ActionForward("index.ops",true);
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		int pj_no = Integer.parseInt(request.getParameter("pj_no"));
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		
		Work work =new Work();
		work.setWo_write(myId);
		work.setWo_title(title);
		work.setWo_content(content);
		work.setWo_StratDate(startDate);
		work.setWo_EndDate(endDate);
		
		
		WorkProService wps=new WorkProService();
		wps.WorkService(work, pj_no,myId);
		
		return forward;
	}

}
