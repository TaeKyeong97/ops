package ops.Notice.Action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;
import static common.ConUtilDAO.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;

public class NoticeWriteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 10*1024*1024;
		ServletContext context = request.getServletContext();
		HttpSession session=request.getSession();
		String emId=(String)session.getAttribute("emID");
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("img");
		
		Notice n = new Notice();
		n.setN_title(multi.getParameter("title"));		
		n.setN_date(new Timestamp(System.currentTimeMillis()));
		n.setN_img(image);
		n.setN_comName(multi.getParameter("comName"));
		n.setN_ceoName(multi.getParameter("ceoName"));
		n.setN_address(multi.getParameter("address"));
		n.setN_job(multi.getParameter("job"));
		n.setN_reCruit(Integer.parseInt(multi.getParameter("reCruit")));
		n.setN_field(multi.getParameter("field"));
		n.setN_gender(multi.getParameter("gender"));
		n.setN_age(multi.getParameter("age"));
		n.setN_acadamiBg(multi.getParameter("acadamiBg"));
		n.setN_endDate(multi.getParameter("endDate"));
		n.setN_sal(multi.getParameter("sal"));
		n.setN_workTerm(multi.getParameter("workTerm"));
		n.setN_workDay(multi.getParameter("workDay"));
		n.setN_workTime(multi.getParameter("workTime"));
		n.setN_workForm(multi.getParameter("workForm"));
		n.setN_name(multi.getParameter("name"));
		n.setN_email(multi.getParameter("email"));
		n.setN_phone(multi.getParameter("phone"));
		n.setN_supportForm(multi.getParameter("supportForm"));
		n.setN_bigo(multi.getParameter("bigo"));
		n.setN_content(multi.getParameter("content"));
		n.setN_id(emId);
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		int x = nd.insertNotice(n);
		
		if(x>0) {
			commit(con);
			forward = new ActionForward("ops/main",true);
		}else {
			rollback(con);
			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('오류');");
			out.println("history.back();");
			out.println("</script>");
		}
		close(con);
		return forward;
	}

}
