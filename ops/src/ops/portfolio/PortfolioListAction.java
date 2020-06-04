package ops.portfolio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

//포트폴리오 종합 리스트
public class PortfolioListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=new ActionForward("../portfolio/view/subPortfolio.jsp",false);
		
		
		return forward;
	}
}
