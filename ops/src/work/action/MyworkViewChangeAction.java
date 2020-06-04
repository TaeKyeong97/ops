package work.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Work;
import comm.Action;
import comm.ActionForward;

public class MyworkViewChangeAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//내가 생성한 업무 상세 수정페이지 보기
		ActionForward forward=null;
		MyWorkViewService mwvs=new MyWorkViewService();
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String wo_noString=request.getParameter("wo_no");
		int wo_no=0;
		if(wo_noString!=null) {
			wo_no=Integer.parseInt(wo_noString);
		}
		Work myworkview=mwvs.myWorkViewservice(wo_no, myId);
		request.setAttribute("myworkview", myworkview);
		
		forward = new ActionForward("myWorkViewChange.jsp",false);
		return forward;
	
	}
}
