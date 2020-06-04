package Project.pro.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;

public class SelectFriendAddService {
	//친구추가
	public int selectFriendAddService(String userId,String myId,String title) {
		int state=0;
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		state=opd.selectFriendAdd(userId, myId, title);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		close(conn);
		
		return state;
	}
}
