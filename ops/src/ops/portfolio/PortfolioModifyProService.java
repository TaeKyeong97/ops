package ops.portfolio;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.portfolio.beans.PortfolioBeans;
public class PortfolioModifyProService {
	//존재 여부 확인
	public boolean isPortfolioModify(int po_no,String po_id){
		Connection conn=getConnection();
		PortfolioDAO ptfd=PortfolioDAO.getInstance();
		ptfd.setConnection(conn);
		boolean state=ptfd.isPortfolioModify(po_no, po_id);
		
		close(conn);
		return state;
	}
	//수정하기
	public boolean portfolioCardModify(PortfolioBeans pfb,String po_no) {
		boolean state=false;
		Connection conn=getConnection();
		PortfolioDAO ptfd=PortfolioDAO.getInstance();
		ptfd.setConnection(conn);
		state=ptfd.portfolioCardModify(pfb);
		ptfd.portfolioCardPluseModify(pfb, po_no);
		if(state==true) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
	
}
