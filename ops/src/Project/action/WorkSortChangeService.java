package Project.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;

public class WorkSortChangeService {
	//업무 구분 변경(신규 업무 내업무 위치)
	public int workSortChangeService(String myId, int pj_no,String []myWorkArray, String []noWorkArray) {
		int state=0;
		Connection conn=getConnection();
		ProjectData pjd = ProjectData.getInstance();
		pjd.setConnection(conn);
		state=pjd.workSortChange(myId,pj_no,myWorkArray,noWorkArray);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		
		close(conn);
		return state;
	}

}
