package ops.portfolio;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.portfolio.beans.PortfolioBeans;

public class MyPortfolioListBestService {
	public ArrayList<PortfolioBeans> PortfolioListBestService() {
		Connection conn=getConnection();
		PortfolioDAO pfd=PortfolioDAO.getInstance();
		pfd.setConnection(conn);
		ArrayList<PortfolioBeans> list=pfd.PortfolioListBest();
		
		
		close(conn);
		return list;
	}
}
