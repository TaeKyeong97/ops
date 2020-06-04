package Project.pro.action;

import java.sql.Connection;

import Project.beans.ProjectGroupProject;

import static comm.JdbcUtil.*;

public class ProjectGroupProService {
	public int gorupProjectInsertService(ProjectGroupProject pgp) {
		int state=0;
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		state=opd.gorupProjectInsert(pgp);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return state;
	}
}
