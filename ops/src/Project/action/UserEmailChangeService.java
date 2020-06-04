package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;
public class UserEmailChangeService {
	public int userInfoChange(String id,String Email,String emailChange,String pw,String sortation) throws Exception {
		int state =0;
		Connection conn=null;
		conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		state=pjd.MemberInfoChange(id,Email,emailChange,pw,sortation);
		
		if(state>0) {
			conn.commit();
		}else {
			conn.rollback();
		}
		
		close(conn);
		return state;
	}
}
