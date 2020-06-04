package Project.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;
public class WithdrawalService {
	//탈퇴
	public int withdrawalService(String myId, String pw) {
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		int state=pjd.withdrawal(myId, pw);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
			
		}
		
		close(conn);
		
		return state;
	}
}
