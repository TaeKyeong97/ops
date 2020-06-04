package Project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class WithdrawalAction implements Action{
	//회원 탈퇴
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String pw=request.getParameter("pw");
		
		WithdrawalService was=new WithdrawalService();
		int state=was.withdrawalService(myId, pw);
		if(state>0) {
			session.invalidate();
		}
		
		forward=new ActionForward("index.ops",true);
		return forward;
	}

}
