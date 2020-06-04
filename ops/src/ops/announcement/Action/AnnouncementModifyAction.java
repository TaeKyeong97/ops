package ops.announcement.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.announcement.Beans.Announcement;

public class AnnouncementModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		AnnouncementDetailService ads = new AnnouncementDetailService();
		int a_no = Integer.parseInt(request.getParameter("a_no"));
	    Announcement a = ads.getAnnouncement(a_no);
	    request.setAttribute("a", a);
	   	
	    ActionForward forward = new ActionForward("announcementModify.jsp",false);
   		return forward; 		
	 }
}