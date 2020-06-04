package ops.announcement.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

public class AnnouncementDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		ActionForward forward = null;
		AnnouncementDeleteService adp = new AnnouncementDeleteService();
		boolean DeleteSuccess = adp.deleteAnnouncement(a_no);
		if(!DeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward("announcementList.no", false);
		}
		return forward;
	}
}
