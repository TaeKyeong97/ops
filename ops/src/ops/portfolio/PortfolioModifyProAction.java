package ops.portfolio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.portfolio.beans.PortfolioBeans;
import ops.portfolio.layout.PortfolioLayout;
//포트폴리오 수정 하기
public class PortfolioModifyProAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		if(request.getParameter("no")!=null&&request.getParameter("layout")!=null) {
			String po_no=request.getParameter("no");
			String layout=request.getParameter("layout");
			PortfolioModifyProService pmps=new PortfolioModifyProService();
			boolean isPortfolioModify=pmps.isPortfolioModify(Integer.parseInt(po_no), userID);
			if(isPortfolioModify){//card
				if(layout.equals("card")) {
					PortfolioLayout pfl=new PortfolioLayout();
					PortfolioBeans pfb=pfl.cardLayout(request, response);
					pfb.setNo(Integer.parseInt(po_no));
					boolean state=pmps.portfolioCardModify(pfb,po_no);
					if(!state) {
						Errorcommand.Error(response, "수정실패");
					}else {
						forward=new ActionForward("../PORTFOLIO/PortfolioView?no="+pfb.getNo()+"&&layout="+pfb.getLayout(),true);
					}
				}else{
					Errorcommand.Error(response, "잘못된 접근입니다.");
				}
			}else {
				Errorcommand.Error(response, "접근권한이 없습니다.");
			}		
		}else {
			Errorcommand.Error(response, "잘못된 접근입니다.");
		}
		
		return forward;
	}
}
