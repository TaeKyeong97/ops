package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.ProjectBean;
public class ProjectCurrentService {
	public ArrayList<ProjectBean> selectMyProjectService(String myid){
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		ArrayList<ProjectBean> list=pjd.selectMyProject(myid);
		
		close(conn);
		
		return list;
	}
	//승인 대기중인 프로젝트
	public ArrayList<ProjectBean> selectMyProjectApprovalService(String myid){
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		ArrayList<ProjectBean> lista=pjd.selectMyProjectApproval(myid);
		
		close(conn);
		
		return lista;
	}
}
