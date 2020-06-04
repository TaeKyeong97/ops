package Project.pro.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.ProjectBean;
import Project.beans.ProjectGroupBean;

public class ProjectGroupPreInfoService {
//특정 프로젝트 그룹 참여인원 정보 가져오기
	public ArrayList<ProjectBean> projectGroupPeInfo(String pjg_no){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<ProjectBean> list=opd.projectGroupPeInfo(pjg_no);

		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}

//특정 프로젝트 그룹 참여인원 정보 가져오기 (배열 번호)
	public ArrayList<ProjectGroupBean> projectGroupPeInfo(ArrayList<ProjectGroupBean> pjg_no){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<ProjectGroupBean> list=opd.projectGroupPeInfo(pjg_no);

		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}
	
}
