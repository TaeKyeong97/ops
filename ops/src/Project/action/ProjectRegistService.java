package Project.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.Timestamp;

import Project.beans.Member;
public class ProjectRegistService {
	//회원가입
	public boolean getInsertMember(Member mb,String userImg,String folder) {
		Connection conn=null;
		boolean isSuccess=false;
		ProjectData pj=ProjectData.getInstance();
		conn=getConnection();
		pj.setConnection(conn);
		int x=pj.insertMember(mb,userImg,folder);
		if(x>0) {
			commit(conn);
			isSuccess=true;
		}else {
			rollback(conn);
		}
		close(conn);
	
		return isSuccess;
	}
	
}
