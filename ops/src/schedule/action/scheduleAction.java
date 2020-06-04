package schedule.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;
import schedule.beans.ScheduleBeans;
//스케줄 페이지
public class scheduleAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward("schedule/schedule.jsp",false);
		int pjNo=0;
		if(request.getParameter("no")!=null) {
			pjNo=Integer.parseInt(request.getParameter("no"));
		}
		
		//스케줄 조회
		ScheduleService schd=new ScheduleService();
		ArrayList<ScheduleBeans> sb=schd.schedule(pjNo);
		request.setAttribute("sbList", sb);
		return forward;
	}
}
