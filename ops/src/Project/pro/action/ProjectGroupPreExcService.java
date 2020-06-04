package Project.pro.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.commit;
import static comm.JdbcUtil.getConnection;
import static comm.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.ProjectBean;

public class ProjectGroupPreExcService {
	//특정프로젝트 그룹 참여자를 제외한 프로젝트 참여인원
	public ArrayList<ProjectBean> ProjectGroupPreExc(int pj_no,int pjg_no){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<ProjectBean> list=opd.ProjectGroupPreExc(pj_no, pjg_no);
		
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}
	public ArrayList<ProjectBean> ProjectGroupPreAll(String pj_no){
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<ProjectBean> list=opd.opMainProjectPerson(pj_no);
		
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}
}
