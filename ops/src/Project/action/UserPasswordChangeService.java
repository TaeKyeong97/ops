package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;
public class UserPasswordChangeService {
	public int userPasswrodChange(String id, String Email, String change,String pw,String sortation) throws Exception{
		int state=0;
		Connection conn=null;
		ProjectData pjd=ProjectData.getInstance();
		conn=getConnection();
		pjd.setConnection(conn);
		
		state=pjd.MemberInfoChange(id, Email, change,pw, sortation);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return state;
	}
}
