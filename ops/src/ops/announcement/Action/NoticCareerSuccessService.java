package ops.announcement.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

public class NoticCareerSuccessService {
	//공고 지원 승인하기
	public int NoticCareerSuccess(int hi_no) {
		int state=0;
		Connection conn=getConnection();
		AnnouncementData ad=new AnnouncementData();
		ad.setConnection(conn);
		state=ad.NoticCareerSuccess(hi_no);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
		
	}
	//승인취소
	public int NoticCareerCance(int hi_no) {
		int state=0;
		Connection conn=getConnection();
		AnnouncementData ad=new AnnouncementData();
		ad.setConnection(conn);
		state=ad.NoticCareerCance(hi_no);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
		
	}
	//지원 거절
	public int noticCareerRefusal(int hi_no,int n_no) {
		int state=0;
		Connection conn=getConnection();
		AnnouncementData ad=new AnnouncementData();
		ad.setConnection(conn);
		state=ad.NoticCareerRefusal(hi_no,n_no);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
		
	}
}
