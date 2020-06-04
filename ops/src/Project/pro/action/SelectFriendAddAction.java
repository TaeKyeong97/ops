package Project.pro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class SelectFriendAddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		//친구 추가
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String userId=request.getParameter("userId");
		String title=request.getParameter("title");
		
		SelectFriendAddService sfas=new SelectFriendAddService();
		int state=sfas.selectFriendAddService(userId, myId, title);
		if(state>0) {
			request.setAttribute("commit","1");
		}else {
			request.setAttribute("commit", "0");
		}
		forward=new ActionForward("search-friendAdd.jsp",false);
		
		
		return forward;
	}
	
}
