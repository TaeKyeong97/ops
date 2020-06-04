package Project.action;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.ProjectGroupBean;

import static comm.JdbcUtil.*;

//조직도 가져오기 DB 연결
public class OrgaChartService {
	//프로젝트 생성자 정보가져오기
	public String searchProjectAdmin(int pjNo) {
		Connection conn=getConnection();
		ProjectData pd=ProjectData.getInstance();
		pd.setConnection(conn);
		String admin=pd.searchProjectAdmin(pjNo);
		close(conn);		
		return admin;
	}
	//프로젝트 그룹별 관리자 정보 가져오기
	public ArrayList<ProjectGroupBean> searchProjectGAdmin(int pjNo){
		Connection conn=getConnection();
		ProjectData pd=ProjectData.getInstance();
		pd.setConnection(conn);
		ArrayList<ProjectGroupBean> list=pd.searchProjectGAdmin(pjNo);
		
		close(conn);
		return list;
	}
	//프로젝트 그룹렬 팀원 정보 가져오기
	public ArrayList<ProjectGroupBean> searchProjectGUser(int pjNo){
		Connection conn=getConnection();
		ProjectData pd=ProjectData.getInstance();
		pd.setConnection(conn);
		ArrayList<ProjectGroupBean> list=pd.searchProjectGUser(pjNo);
		
		close(conn);
		return list;
	}
	
}
