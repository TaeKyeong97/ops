package ops.portfolio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.member.LoginCk;
import ops.portfolio.beans.CardBoardBeans;
import ops.portfolio.beans.PortfolioBeans;

//포트폴리오 수정페이지(내용가져오기)
public class PortfolioModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=new ActionForward("../portfolio/modify/cardModify.jsp",false);
		LoginCk lc=new LoginCk(request,response);
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		if(userID!=null&&request.getParameter("no")!=null&&request.getParameter("layout")!=null) {
			int no=Integer.parseInt(request.getParameter("no"));
			String layout=request.getParameter("layout");
			PortfolioViewService pfvs=new PortfolioViewService();
			PortfolioBeans pfb=pfvs.portfolioView(no, userID, layout);
			ArrayList<CardBoardBeans> cbb=pfvs.portfolioCardView(no);
			request.setAttribute("view", pfb);
			request.setAttribute("cbb", cbb);
		}
		
		
		return forward;
	}
}
