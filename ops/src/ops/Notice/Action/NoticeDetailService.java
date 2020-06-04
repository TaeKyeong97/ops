package ops.Notice.Action;

import java.sql.Connection;
import static common.ConUtilDAO.*;
import ops.Notice.Beans.Notice;

public class NoticeDetailService {
	public Notice getNotice(int n_no) throws Exception {
		
		Notice n = null;
		Connection con = getConnection();
		NoticeData nd = NoticeData.getInstance();
		nd.setConnection(con);
		
		n = nd.selectNoticeDetail(n_no);
		close(con);
		
		return n;
	}
}
