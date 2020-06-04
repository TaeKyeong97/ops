package Project.action;

import java.sql.Connection;

import Project.beans.Work;

import static comm.JdbcUtil.*;

public class WorkProService{
	public int WorkService(Work work, int pj_no,String myId) throws Exception{
		int state=0;
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		state=pjd.Work(work, pj_no,myId);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);		
		return state;
	}
}
