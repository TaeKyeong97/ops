package Project.pro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class FriendAcknoAddAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//친구 추가 승인 거절 하기
		ActionForward forward=null;
		HttpSession session =request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String id=request.getParameter("userId");
		String sta=request.getParameter("state");
		String comp=request.getParameter("comp");
		
		FriendAcknoAddService faa =new FriendAcknoAddService();
		int state=faa.friendAcknoAddService(id, myId,sta,comp);
		
		//친구 추가 완료 되면 1 return 
		if(state>0) {
			request.setAttribute("commit","1");
		}else {
			//친구 추가 오류 0 return
			request.setAttribute("commit", "0");
		}
		
		
		forward=new ActionForward("friendAcknoAdd.jsp",false);
		
		return forward;
		
	}
}
