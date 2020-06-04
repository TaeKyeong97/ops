package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;

public class projectMainSettingService {
	
	public int projectMainSettingServices(String myid,String no) {
		int state=0;
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		state=pjd.projectMainSetting(myid, no);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return state;
	}
}
