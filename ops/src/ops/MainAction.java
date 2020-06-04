package ops;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.member.LoginCk;
import ops.portfolio.MyPortfolioListBestService;
import ops.portfolio.beans.PortfolioBeans;
import ops.search.NoticBeans;
import ops.search.NoticSearchService;

//메인 페이지
public class MainAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../main.jsp",false);
		//로그인 확인
		LoginCk lck=new LoginCk(request, response);
		
		MyPortfolioListBestService bs=new MyPortfolioListBestService();
		ArrayList<PortfolioBeans> bss= bs.PortfolioListBestService();
		NoticSearchService nss=new NoticSearchService();
		ArrayList<NoticBeans> nbl=nss.noticSearch();
		
		request.setAttribute("bss", bss);
		request.setAttribute("nbl", nbl);
		return forward;
	}
}
