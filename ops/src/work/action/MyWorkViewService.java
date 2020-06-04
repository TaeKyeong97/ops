package work.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import Project.action.ProjectData;
import Project.beans.Work;

public class MyWorkViewService {
	public Work myWorkViewservice(int wo_no,String myId) {
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		Work work= pjd.myWorkView(wo_no, myId);
		
		close(conn);
		return work;
	}
}
