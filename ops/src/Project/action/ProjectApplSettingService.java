package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;
public class ProjectApplSettingService {
	//프로젝트 승인하기
	public int ProjectApplSetting(String myid,String no,String Applno) {
		int state=0;
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		state=pjd.projectApplSetting(myid,no,Applno);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		close(conn);
		
		return state;
	}
}
