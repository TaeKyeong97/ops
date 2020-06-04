package ops.Notice.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.Notice.Beans.Notice;

public class NoticeModifyProService {
	public boolean NoticeNo(int n_no) throws Exception {
		
		boolean noticeNo = false;
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		noticeNo = nd.isNoticeNo(n_no);
		close(con);
		return noticeNo;
		
	}
	public boolean modifyNotice(Notice detail) throws Exception {
		
		boolean ModifySuccess = false;
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		int updateSuccess = nd.updateNotice(detail);
		if(updateSuccess > 0){
			commit(con);
			ModifySuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return ModifySuccess;
	
	}
}

