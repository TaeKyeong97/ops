package work.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.Work;
import comm.Action;
import comm.ActionForward;

public class MyWorkListAction implements Action {
	// 내가 생성한 업무 리스트 조회
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		
		String ws_noString=request.getParameter("ws_no");
		int ws_no=0;
		if(ws_noString!=null) {
			ws_no=Integer.parseInt(ws_noString);
		}
		
		MyWorkListService mwls=new MyWorkListService();
		ArrayList<Work> workMyList=mwls.myworkListService(myId);
		request.setAttribute("workMyList", workMyList);
		
		
		return forward;
	}
	
}
