package Project.pro.action;

import java.sql.Connection;
import java.util.ArrayList;
import static comm.JdbcUtil.*;
import Project.beans.ProjectGroupProject;

public class ProjectGroupService {
	public ArrayList<ProjectGroupProject> ProjectGroupListService(int pjg_no,String myId) {
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);		
		ArrayList<ProjectGroupProject> list=opd.ProjectGroupList(pjg_no, myId);
		
		
		close(conn);
		return list;
	}
}
