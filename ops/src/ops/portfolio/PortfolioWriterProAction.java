package ops.portfolio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dataCenter.ApprovalStateService;
import dataCenter.CollectDataService;
import ops.portfolio.beans.PortfolioBeans;
import ops.portfolio.layout.PortfolioLayout;

public class PortfolioWriterProAction implements Action{
	//포트폴리오 작성 처리페이지
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		String layout=null;
		if(request.getParameter("layout")!=null) {
			layout=request.getParameter("layout");
			if(layout.equals("card")) {//card
				PortfolioLayout pfl=new PortfolioLayout();
				PortfolioBeans ptfb=pfl.cardLayout(request, response);
				PortfolioWriterService pws=new PortfolioWriterService();
				int state=pws.portfolioCardWriter(ptfb);
				if(state>0) {
					int no=pws.PortfolioMax(ptfb.getId());
					pws.portfolioCardPluseWriter(ptfb.getCard_content(),no);
					ApprovalStateService ass=new ApprovalStateService();
					boolean isConsent=ass.memberState(request);
					if(isConsent) {
						CollectDataService cds=new CollectDataService();
						cds.collectData(request, "card");
					}
					forward=new ActionForward("../PORTFOLIO/PortfolioView?no="+no+"&&layout="+ptfb.getLayout(),true);
				}else {
					Errorcommand.Error(response,"등록실패");
				}
			}else if(layout.equals("post")) {//post
				PortfolioLayout pfl=new PortfolioLayout();
				PortfolioBeans ptfb=pfl.postLayout(request, response);
				PortfolioWriterService pws=new PortfolioWriterService();
				int state=pws.portfolioCardWriter(ptfb);	//현재 layout post
				if(state>0) {
					int no=pws.PortfolioMax(ptfb.getId());
					forward=new ActionForward("../PORTFOLIO/PortfolioView?no="+no+"&&layout="+ptfb.getLayout(),true);
				}
				
			}else{
				Errorcommand.Error(response,"존재하지 않는 레이아웃입니다.");
			}
		}else{
			Errorcommand.Error(response,"잘못된 접근이 감지되었습니다.");
		}
		
		
		return forward;
	}

}
