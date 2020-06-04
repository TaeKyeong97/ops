package ops.board.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
//질문 작성 페이지
public class BorderWriteFormAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		
		
		forward = new ActionForward("./boardWrite.jsp",true);
		return forward;
	}
	
}
