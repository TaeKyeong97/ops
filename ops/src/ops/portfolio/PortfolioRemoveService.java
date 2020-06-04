package ops.portfolio;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;
public class PortfolioRemoveService {
	public boolean portfolioRemove(int no, String userID) {
		boolean state=false;
		Connection conn=getConnection();
		PortfolioDAO pfd=PortfolioDAO.getInstance();
		pfd.setConnection(conn);
		pfd.portCareerRemove(no);
		state=pfd.portfolioCardRemove(no);
		state=pfd.portfolioRemove(no, userID);
		if(state) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);		
		return state;
	}
}
