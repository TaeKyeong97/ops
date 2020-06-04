package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

//회원가입 입력 폼 페이지
public class JoinForm2Action implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../join/joinForm2.jsp",false);
		
		return forward;
	}
}
