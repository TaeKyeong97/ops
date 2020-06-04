package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.announcement.Beans.Announcement;


public class AnnouncementDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
			
		Announcement detail = null;
		Connection con = getConnection();
		AnnouncementData ad = AnnouncementData.getInstance();
		ad.setConnection(con);
		detail = ad.selectAnnouncementDetail(a_no);
		close(con);
		
		request.setAttribute("detail", detail);
		ActionForward forward = new ActionForward("announcementDetail.jsp",false);
		return forward;
}
}
