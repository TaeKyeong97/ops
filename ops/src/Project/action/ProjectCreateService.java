package Project.action;

import static comm.JdbcUtil.*;

import java.sql.Connection;

import Project.beans.ProjectBean;

public class ProjectCreateService {
	public String createProject(ProjectBean pb,String buy_price) {
		//프로젝트 생성
		int state=0;
		Connection conn=null;
		conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		
		state=pjd.createProject(pb, buy_price);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		//생성한 프로젝트 번호 반환
		
		String pj_no=Integer.toString(pjd.createNoProject(pb));
		
		close(conn);
		
		return pj_no;
	}
}
