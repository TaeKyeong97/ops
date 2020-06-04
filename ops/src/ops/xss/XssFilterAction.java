package ops.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

//필터 테스트 페이지
public class XssFilterAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../xss/xssFilter.jsp",false);
				
		return forward;
	}
}
