package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
//아이디 중복 체크
public class OverCkAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../join/overCK.jsp",false);
		String id=request.getParameter("EM_id");
		
		OverCkService ocks=new OverCkService();
		int state=ocks.overCkService(id);
		
		if(state==1) {
			request.setAttribute("idOver", "1");
		}else {
			request.setAttribute("idOver", "0");
		}
		
		return forward;
	}
}
