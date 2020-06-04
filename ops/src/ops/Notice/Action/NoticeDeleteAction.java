package ops.Notice.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

public class NoticeDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		ActionForward forward = null;
		NoticeDeleteService ndp = new NoticeDeleteService();
		boolean DeleteSuccess = ndp.deleteNotice(n_no);
		if(!DeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward("noticeList.no", true);
		}
		return forward;
	}
}
