package work.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;
import Project.action.ProjectData;
import Project.beans.Work;

public class WorkViewService {
	public Work workviewService(int ws_no) {
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		Work work= pjd.workView(ws_no);
		
		close(conn);
		return work;
	}

}
