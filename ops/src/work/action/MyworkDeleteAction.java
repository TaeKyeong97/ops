package work.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class MyworkDeleteAction implements Action {
	//내가 생성한 업무 삭제하기
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String wo_noString=request.getParameter("wo_no");
		int wo_no=0;
		if(wo_noString!=null) {
			wo_no=Integer.parseInt(wo_noString);
		}
		MyworkDeleteService mda =new MyworkDeleteService();
		mda.myworkDeleteService(wo_no, myId);
		
		return forward;
	}
	
}
