package ops.portfolio;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.portfolio.beans.CardBoardBeans;
import ops.portfolio.beans.PortfolioBeans;
//포트폴리오 작성 처리하기
public class PortfolioWriterService {
	public int portfolioCardWriter(PortfolioBeans ptfb) {
		int state=0;
		Connection conn=getConnection();
		PortfolioDAO prt=PortfolioDAO.getInstance();
		prt.setConnection(conn);
		state=prt.portfolioCardWriterPro(ptfb);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
	public int portfolioCardPluseWriter(String[] content,int no) {
		int state=0;
		Connection conn=getConnection();
		PortfolioDAO prt=PortfolioDAO.getInstance();
		prt.setConnection(conn);
		state=prt.portfolioCardWritePluse(content,no);
		close(conn);
		return state;
	}
	public int PortfolioMax(String userID) {
		Connection conn=getConnection();
		PortfolioDAO pfd=PortfolioDAO.getInstance();
		pfd.setConnection(conn);
		int state=pfd.PortfolioMax(userID);
		
		close(conn);
		return state;
	}
}
