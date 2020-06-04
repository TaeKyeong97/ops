package ops.portfolio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.portfolio.beans.PortfolioBeans;

public class MyPortfolioListCkeckAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../portfolio/myPortfolio/myPortfolioCkeck.jsp",false);
		//이력서 작성시 포트폴리오 사용 여부
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		MyPortfolioListService mpfls=new MyPortfolioListService();
		ArrayList<PortfolioBeans> mpfl= mpfls.myPortfolioList(userID);
		request.setAttribute("mpfl",mpfl);
		
		return forward;
	}
}
