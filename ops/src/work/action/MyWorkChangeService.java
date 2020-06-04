package work.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;

import java.sql.Connection;

import Project.action.ProjectData;
import Project.beans.Work;

public class MyWorkChangeService {
	public int myWorkChangeService(int wo_no, String myId,Work work) {
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		int state=pjd.myWorkChange(wo_no, myId,work);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return state;
	}
}
