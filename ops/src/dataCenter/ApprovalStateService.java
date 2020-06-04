package dataCenter;

import static common.DataCenterDAO.close;
import static common.DataCenterDAO.getConnection;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApprovalStateService {
	//동의,거절 여부 확인
	public boolean ApprovalState(HttpServletRequest request) {
		boolean state=false;
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		Connection conn=getConnection();
		CenterDAO cd=CenterDAO.getInstance();
		cd.setConnection(conn);
		state=cd.ApprovalState(userID);
		
		close(conn);
		return state;
	}
	//동의 여부 확인
	public boolean memberState(HttpServletRequest request) {
		boolean state=false;
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		Connection conn=getConnection();
		CenterDAO ctd=CenterDAO.getInstance();
		ctd.setConnection(conn);
		state=ctd.memberState(userID);
		
		close(conn);
		return state;
	}
	
}
