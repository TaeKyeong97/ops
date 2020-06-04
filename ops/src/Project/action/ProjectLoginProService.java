package Project.action;
import static comm.JdbcUtil.close;
import static comm.JdbcUtil.getConnection;

import java.sql.Connection;
public class ProjectLoginProService {
	public int loginAction(String id,String pw) {
		int state=0;
		Connection conn=getConnection();
		ProjectData lem=ProjectData.getInstance();
		lem.setConnection(conn);
		state=lem.loginEMember(id, pw);
		close(conn);
		return state;
	}
}
