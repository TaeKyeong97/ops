package ops.portfolio;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.portfolio.beans.CardBoardBeans;
import ops.portfolio.beans.PortfolioBeans;

//포트폴리오 조회
public class PortfolioViewService {
	public PortfolioBeans portfolioView(int no,String userID, String layout) {
		Connection conn=getConnection();
		PortfolioDAO pfd=PortfolioDAO.getInstance();
		pfd.setConnection(conn);
		PortfolioBeans pfb=pfd.portfolioView(no, userID, layout);
		
		close(conn);
		return pfb;
	}
	/*card pluse*/
	public ArrayList<CardBoardBeans> portfolioCardView(int po_noFk) {
		Connection conn=getConnection();
		PortfolioDAO pfd=PortfolioDAO.getInstance();
		pfd.setConnection(conn);
		ArrayList<CardBoardBeans> list=pfd.portfolioCardView(po_noFk);
		
		close(conn);
		return list;
	}
}
