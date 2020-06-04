package ops.Notice.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;

public class NoticeListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		NoticeListService nls = new NoticeListService();
   		ArrayList<Notice> noticeList = nls.getNoticeList();
   		request.setAttribute("noticeList", noticeList);
   		forward = new ActionForward("management/noticeList.jsp",false);
   		return forward;
	}
}

