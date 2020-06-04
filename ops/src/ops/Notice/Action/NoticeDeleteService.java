package ops.Notice.Action;

import static common.ConUtilDAO.*;
import java.sql.Connection;


public class NoticeDeleteService {
	public boolean noticeNo(int n_no) throws Exception {
		boolean noticeNo = false;
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		noticeNo = nd.isNoticeNo(n_no);
		close(con);
		return noticeNo;
		
	}
	public boolean deleteNotice(int n_no) throws Exception{
		boolean deleteSuccess = false;
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		int a = nd.deleteNotice(n_no);
		
		if(a>0){
			commit(con);
			deleteSuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return deleteSuccess;
	}
}

