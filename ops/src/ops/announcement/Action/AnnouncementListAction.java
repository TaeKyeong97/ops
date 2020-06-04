package ops.announcement.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.announcement.Beans.Announcement;


public class AnnouncementListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		AnnouncementListService als = new AnnouncementListService();
   		ArrayList<Announcement> announcementList = als.getAnnouncementList();
   		request.setAttribute("announcementList", announcementList);
   		forward = new ActionForward("./announcementList.jsp",false);
   		return forward;
	}
}
