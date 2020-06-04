package ops.Notice.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.Notice.Beans.Notice;


public class NoticeListService {
	public ArrayList<Notice> getNoticeList() {
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		ArrayList<Notice> noticeList = nd.selectNoticeList();
		close(con);
		return noticeList;
	}

}

