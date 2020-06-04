package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.ProjectBean;

public class ProjectCreateListService {
	//MY 프로젝트 생성 리스트
	public ArrayList<ProjectBean> projectCreateListServices(String myid){
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		
		ArrayList<ProjectBean> list = pjd.myProjectList(myid);
		
		close(conn);
		return list;
	}
}
