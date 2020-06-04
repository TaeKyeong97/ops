package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.MemberAll;

public class PjCreateViewService {
	public ArrayList<MemberAll> MemberInfoSelect(String myId) throws Exception{
		Connection conn=getConnection();
		
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		ArrayList<MemberAll> list=null;
		list=pjd.memberInfoSelect(myId);
		
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}
}
