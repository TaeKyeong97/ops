package work.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;

import Project.action.ProjectData;

public class MyworkDeleteService {
	//내가 생성한 업무 삭제하기
	public int myworkDeleteService(int wo_no, String myId) {
		int state=0;
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		state=pjd.MyworkDelete(wo_no, myId);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		close(conn);		
		return state;
	}
}
