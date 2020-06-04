package Project.pro.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;

import java.sql.Connection;

public class projectGroupAddService{
	//프로젝트 그룹 인원 추가(수정)
	public int ProjectPreAddService(String userId[],int pj_no ,int pjg_no) {
		int state=0;
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		state=opd.ProjectPreAdd(userId, pj_no,pjg_no);
		
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return state;
	}
}
