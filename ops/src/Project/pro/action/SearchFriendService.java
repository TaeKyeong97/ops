package Project.pro.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;
import Project.beans.Member;

public class SearchFriendService {
	//친구 찾기
	public Member searchFriendSerivce(String userId,String myId) {
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		Member mb=opd.searchFriend(userId, myId);
		if(mb!=null) {
			//commit(conn); 검색 기능만 있어 따로 넣지 않음
		}else {
			//rollback(conn);
		}
		
		close(conn);
		
		return mb;
	}
}
