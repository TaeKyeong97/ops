package ops.announcement.Action;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ActionForward;
import ops.announcement.Beans.Announcement;

public class AnnouncementWriteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		AnnouncementWriteService aws = new AnnouncementWriteService();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 1024*1024*10;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("img");
		
		Announcement a = new Announcement();
		a.setA_id(multi.getParameter("id"));
		a.setA_title(multi.getParameter("title"));
		a.setA_content(multi.getParameter("content"));
		a.setA_date(new Timestamp(System.currentTimeMillis()));
		a.setA_img(image);
		aws.insertAnnouncement(a);
		
		forward = new ActionForward("./mainForm.jsp",true);
		return forward;
	}
}
