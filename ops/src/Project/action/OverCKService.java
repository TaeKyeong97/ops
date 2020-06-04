package Project.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;
public class OverCKService {
	public int overCkService(String id) {
		int state=0;
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		state=pjd.joinOverCk(id);
		
		
		close(conn);
		return state;
	}
}
