package ops.portfolio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
//포트폴리오 삭제
public class PortfolioRemoveAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		if(request.getParameter("no")!=null) {
			String no=request.getParameter("no");
			PortfolioRemoveService pfrs=new PortfolioRemoveService();
			boolean isRemove=pfrs.portfolioRemove(Integer.parseInt(no), userID);
			if(isRemove) {
				forward = new ActionForward("../ops/main",true);
			}else {
				Errorcommand.Error(response, "잘못된 접근 입니다.");
			}
		}
		
		return forward;
	}
}
