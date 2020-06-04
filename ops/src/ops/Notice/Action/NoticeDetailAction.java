package ops.Notice.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;
import ops.announcement.Action.NoticSupportService;


public class NoticeDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("userID");
		
		int n_no = Integer.parseInt(request.getParameter("n_no"));
			
		Notice detail = null;
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		detail = nd.selectNoticeDetail(n_no);
		close(con);
		
		//공고 지원 이력 조회
		NoticSupportService ncs=new NoticSupportService();
		boolean ncsState=ncs.NoticCareerState(n_no, myId);
		
		request.setAttribute("detail", detail);
		request.setAttribute("ncsState", ncsState);
		ActionForward forward = new ActionForward("management/noticeDetail.jsp",false);
		return forward;
}
}
