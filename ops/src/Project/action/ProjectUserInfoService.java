package Project.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.getConnection;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;

import Project.beans.Member;
import Project.beans.ProjectBean;
public class ProjectUserInfoService {
	public Member userInfoService(String id){
		
		Connection conn=null;
		conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		Member list=pjd.userInfo(id);
		
		
		close(conn);
		return list;
	}
	
	// 사용이 이름
	public String loginName(String id) {
		Connection conn=null;
		conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		String myName=pjd.loginName(id);
		
		
		close(conn);
		return myName;
	}
	
	//프로젝트 1나 가져오기(대표프로젝트 지정을위해)
	public ArrayList<ProjectBean> projectSelectMainService(String pj_admin){
		Connection conn=null;
		ArrayList<ProjectBean> list=null;
		ProjectData pjd=ProjectData.getInstance();
		conn=getConnection();
		
		pjd.setConnection(conn);
		try {
			list=pjd.projectSelectMain(pj_admin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		close(conn);
		return list;
	}
}
