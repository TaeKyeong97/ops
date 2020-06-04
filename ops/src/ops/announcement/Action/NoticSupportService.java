package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

public class NoticSupportService {
	//공고 지원하기 (이력서 제출 엑션)
	public int noticSupport(String myId,int ca_no, int n_no) {
		int state=0;
		Connection conn=getConnection();
		AnnouncementData ad=AnnouncementData.getInstance();
		ad.setConnection(conn);
		state=ad.NotiCareerSupport(myId, ca_no, n_no);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);		
		return state;
	}
	
	//공고 지원여부 확인
	public boolean NoticCareerState(int n_no, String myId) {
		boolean state=false;
		Connection conn=getConnection();
		AnnouncementData ad=AnnouncementData.getInstance();
		ad.setConnection(conn);
		state=ad.NoticCareerState(n_no, myId);
		
		close(conn);
		return state;
	}
}
