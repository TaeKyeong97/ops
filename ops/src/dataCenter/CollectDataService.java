package dataCenter;

import static common.DataCenterDAO.close;
import static common.DataCenterDAO.commit;
import static common.DataCenterDAO.getConnection;
import static common.DataCenterDAO.rollback;
import java.sql.Connection;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class CollectDataService {
	//수집 정보 저장
	public boolean collectData(HttpServletRequest request, String boardForm) {
		boolean state=false;
		HttpSession session=request.getSession();
		String userID=(String)session.getAttribute("userID");
		Connection conn=getConnection();
		CenterDAO cd=CenterDAO.getInstance();
		cd.setConnection(conn);
		state=cd.collectSave(boardForm, userID, new Timestamp(System.currentTimeMillis()));
		if(state) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
}
