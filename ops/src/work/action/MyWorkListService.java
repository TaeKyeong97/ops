package work.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import Project.action.ProjectData;
import Project.beans.Work;

public class MyWorkListService {
public ArrayList<Work> myworkListService(String myId) {
		
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		ArrayList<Work> list = pjd.myWorkList(myId);
		
		close(conn);
		return list;
	}

}
