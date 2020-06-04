package ops.portfolio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.member.LoginCk;
import ops.member.UserNameFiendService;
import ops.portfolio.beans.CardBoardBeans;
import ops.portfolio.beans.PortfolioBeans;
//포트폴리오 조회
public class PortfolioViewAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		LoginCk lck=new LoginCk(request,response);
		String param[]= {"layout","no"};
		StringBuffer parameter=Parameters.isParameter(request, param);
		String paraBuffer[]=parameter.toString().split(",");
		if(paraBuffer.length==param.length) {
			String layout=paraBuffer[0];
			String no=paraBuffer[1];
			PortfolioViewService portfolioView=new PortfolioViewService();
			PortfolioBeans pfb=portfolioView.portfolioView(Integer.parseInt(no), userID, layout);
			if(pfb!=null) {
				ArrayList<CardBoardBeans> cardList=portfolioView.portfolioCardView(Integer.parseInt(no));
				UserNameFiendService unfs=new UserNameFiendService();
				request.setAttribute("userName", unfs.userNameFiend(pfb.getId()));
				request.setAttribute("cardList", cardList);
				request.setAttribute("view", pfb);
				forward=new ActionForward("../portfolio/view/cardView.jsp",false);
			}else {
				Errorcommand.Error(response,"존재하지 않는 게시물 입니다.");
			}
			
		}else {
			Errorcommand.Error(response,"존재하지 않는 게시물 입니다.");
		}
		
		
		
		return forward;
	}
}
