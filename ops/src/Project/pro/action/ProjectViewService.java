package Project.pro.action;

import java.sql.Connection;
import java.util.ArrayList;
import static comm.JdbcUtil.*;
import Project.beans.ProjectGroupProject;

public class ProjectViewService {
	//그룹 프로젝트 상세 보기
	public ProjectGroupProject ProjectGroup(int pjg_no, String myId, int pjgp_no){
		Connection conn=getConnection();
		OpData opd= OpData.getInstance();
		opd.setConnection(conn);
		ProjectGroupProject list=opd.ProjectGroup(pjg_no, myId,pjgp_no);
		

		close(conn);	
		
		return list;
	}
}
