package schedule.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schedule.beans.ScheduleBeans;
//파라미터 받기
public class ScheduleParam {
	public ScheduleParam() {}
	public ScheduleBeans scheduleParams(HttpServletRequest request,HttpServletResponse response) {
		int pjno=0;
		int no=0;
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		String startMonth=request.getParameter("startMonth");
		String ampm=request.getParameter("ampm");
		String endMonth=request.getParameter("endMonth");
		String contenta=request.getParameter("contenta");
		if(request.getParameter("no")!=null) {
			pjno=Integer.parseInt(request.getParameter("no"));
		}
		if(request.getParameter("noNum")!=null) {
			no=Integer.parseInt(request.getParameter("noNum"));
		}
		ScheduleBeans sb=new ScheduleBeans();
		sb.setPj_no(pjno);
		sb.setStartDate(startDate);
		sb.setEndDate(endDate);
		sb.setStartMonth(startMonth);
		sb.setAmpm(ampm);
		sb.setEndMonth(endMonth);
		sb.setEndDate(endDate);
		sb.setNo(no);
		sb.setContent(contenta);
		return sb;
	}
}
