package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.member.beans.MemberBean;

public class myPageAction implements Action {
	//회원페이지
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../member/myPage.jsp",false);
		HttpSession session=request.getSession();
		
		//로그인 확인
		LoginCk lck=new LoginCk(request, response);
		//넘어오는값
		String memberId=(String)session.getAttribute("userID");
		
		//개인페이지 회원 정보 가져오기
		MyPageService mps=new MyPageService();
		MemberBean mb=mps.myPageService(memberId);
		request.setAttribute("mb", mb);
		
		return forward;
	}

}
