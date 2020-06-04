package ops.announcement.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.announcement.Beans.Announcement;

public class AnnouncementModifyProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		AnnouncementModifyProService amps = new AnnouncementModifyProService();
		ActionForward forward = null;
		boolean isSuccess = false;
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		
		Announcement a = new Announcement();
		boolean isAnnouncementNo = amps.AnnouncementNo(a_no);
		if(!isAnnouncementNo){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('접근실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			a.setA_no(a_no);
			a.setA_title(request.getParameter("title"));
			a.setA_content(request.getParameter("content"));
			a.setA_img(request.getParameter("img"));	
			isAnnouncementNo = amps.modifyAnnouncement(a);
			
			if(!isSuccess){
				forward = new ActionForward("announcementList.no", false);
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패.');");
				out.println("history.back()");
				out.println("</script>");						
			}
		}
		return forward;
	}
}
