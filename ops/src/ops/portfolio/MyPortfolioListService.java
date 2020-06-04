package ops.portfolio;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.portfolio.beans.PortfolioBeans;

public class MyPortfolioListService {
	public ArrayList<PortfolioBeans> myPortfolioList(String userID){
		Connection conn=getConnection();
		PortfolioDAO pfd=PortfolioDAO.getInstance();
		pfd.setConnection(conn);
		ArrayList<PortfolioBeans> list=pfd.myPortfolioList(userID);
		
		close(conn);		
		return list;
	}
}
