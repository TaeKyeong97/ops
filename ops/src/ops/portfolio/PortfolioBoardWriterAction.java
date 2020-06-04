package ops.portfolio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dataCenter.ApprovalStateService;
import ops.member.LoginCk;

//Board 포트폴리오 작성
public class PortfolioBoardWriterAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../portfolio/Editor/workspace/editor.jsp",false);
		LoginCk lc=new LoginCk(request,response);
		ApprovalStateService ass=new ApprovalStateService();
		boolean appr=ass.ApprovalState(request);
		request.setAttribute("appr", appr);
		
		return forward;
	}
}
