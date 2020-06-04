package ops.portfolio;

import java.sql.Connection;
import static common.ConUtilDAO.*;
//포트폴리오가 이력서에 연결된 갯수 반환
public class PortfolioCareerLinkSizeService {
	public int portfolioCareerLinkSize(int po_no) {
		int state=0;
		Connection conn=getConnection();
		PortfolioDAO pfd=PortfolioDAO.getInstance();
		pfd.setConnection(conn);
		state=pfd.portCareerLinkList(po_no);
		
		close(conn);
		return state;
	}
}
