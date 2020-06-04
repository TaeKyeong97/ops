package ops.portfolio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

//현재 포트폴리가 이력서 작성페이지와 연결된 갯수 반환
public class PortfolioCareerLinkSizeAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward("../portfolio/view/deleteWindow/deleteWindows.jsp",false);
		String po_no=request.getParameter("no");
		if(po_no!=null) {
			PortfolioCareerLinkSizeService pfcls=new PortfolioCareerLinkSizeService();
			int pfclsSize=pfcls.portfolioCareerLinkSize(Integer.parseInt(po_no));
			request.setAttribute("pfclsSize", pfclsSize);
		}
		return forward;
	}
}
