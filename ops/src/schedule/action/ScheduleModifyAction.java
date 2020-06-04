package schedule.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;
import schedule.beans.ScheduleBeans;
//스케줄 수정하기
public class ScheduleModifyAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		ScheduleParam sps=new ScheduleParam();
		ScheduleBeans sb=sps.scheduleParams(request, response);
		
		ScheduleModifyService sms=new ScheduleModifyService();
		sms.ScheduleModify(sb);
		forward=new ActionForward("schedule.ops?no="+request.getParameter("no"),true);
		return forward;
	}
}
