package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
//아이디 중복 체크(기업)
public class OverCk2Action implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../join/overCK2.jsp",false);
		String id=request.getParameter("EM_id");
		
		OverCkService ocks=new OverCkService();
		int state=ocks.overCk2Service(id);
		
		if(state==1) {
			request.setAttribute("idOver", "1");
		}else {
			request.setAttribute("idOver", "0");
		}
		
		return forward;
	}
}
