package Project.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;

import java.sql.Connection;


public class pgAdminSettingService {
	
	//프로젝트 그룹별 팀장 설정
	public int pgAdminSettingPro(String pjg_admin,int pjpNoFk) {
		Connection conn=getConnection();
		ProjectData pd=ProjectData.getInstance();
		pd.setConnection(conn);
		int state=pd.pgAdminSetting(pjpNoFk, pjg_admin);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
}
