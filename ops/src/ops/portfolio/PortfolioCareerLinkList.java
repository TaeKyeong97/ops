package ops.portfolio;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.portfolio.beans.PortfolioBeans;

//포트폴리오 이력서 연결 포트폴리오 리스트 조회
public class PortfolioCareerLinkList {
	public ArrayList<PortfolioBeans> portfolioCareerList(int ca_no){
		Connection conn=getConnection();
		PortfolioDAO pd=PortfolioDAO.getInstance();
		pd.setConnection(conn);
		ArrayList<PortfolioBeans> list=pd.portfolioCareerList(ca_no);
		
		close(conn);		
		return list;
	}
}
