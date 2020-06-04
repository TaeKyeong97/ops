package Project.pro.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;

public class FriendAcknoAddService {
	//친구 승인 거절하기
	public int friendAcknoAddService(String id,String myId,String sta,String comp) {
		int state=0;
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		state=opd.friendAcknoAdd(id, myId, sta,comp);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
}
