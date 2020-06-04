package ops.Notice.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;


public class NoticeModifyAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 	
		 	NoticeDetailService nds = new NoticeDetailService();
			int n_no = Integer.parseInt(request.getParameter("n_no"));
		    Notice n = nds.getNotice(n_no);
		    request.setAttribute("n", n);
		    
		   	ActionForward forward = new ActionForward("noticeModify.jsp",false);
	   		
	   		return forward;
	   		
	 }

}

