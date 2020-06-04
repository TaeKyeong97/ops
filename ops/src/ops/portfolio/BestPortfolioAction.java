package ops.portfolio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.portfolio.beans.PortfolioBeans;

public class BestPortfolioAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		
		MyPortfolioListBestService bs=new MyPortfolioListBestService();
		ArrayList<PortfolioBeans> bss= bs.PortfolioListBestService();
		request.setAttribute("bss", bss);
		forward=new ActionForward("",false);
		return forward;
	}
}
