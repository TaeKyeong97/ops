package Project.action;

import java.sql.Connection;
import java.util.ArrayList;
import static comm.JdbcUtil.*;
import Project.beans.Work;

public class WorkListService {
	public ArrayList<Work> worklistService(int pj_no, String myId) {
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		ArrayList<Work> list=pjd.workList(pj_no, myId);
		
		
		close(conn);
		return list;
	}
	
	//내업무에있는 신규 업무 조회
	public ArrayList<Work> workMylistService(int pj_no, String myId) {
		Connection conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		ArrayList<Work> list=pjd.workMyList(pj_no, myId);
		
		
		close(conn);
		return list;
	}
}
