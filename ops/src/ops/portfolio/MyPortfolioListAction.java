package ops.portfolio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.member.LoginCk;
import ops.portfolio.beans.PortfolioBeans;

//내가 작성한 포트폴리오 리스트
public class MyPortfolioListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=new ActionForward("../portfolio/myPortfolio/myPortfolio.jsp",false);
		LoginCk lc=new LoginCk(request,response);
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		
		MyPortfolioListService mpfl=new MyPortfolioListService();
		ArrayList<PortfolioBeans> pfb=mpfl.myPortfolioList(userID);
		request.setAttribute("pfb",pfb);
		
		return forward;
	}
}
