package schedule.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Action;
import comm.ActionForward;
import schedule.beans.ScheduleBeans;

//스케줄 등록
public class ScheduleProAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) {
		ActionForward forward=null;
		//받기
		ScheduleParam sp=new ScheduleParam();
		ScheduleBeans sb=sp.scheduleParams(request, response);
		System.out.println(sb.getEndMonth());
		//스케줄 등록
		ScheduleProService sdp=new ScheduleProService();
		sdp.SchedulePro(sb);
		
		return forward;
	}
}
