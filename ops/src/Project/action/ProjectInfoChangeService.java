package Project.action;

import static comm.JdbcUtil.close;
import static comm.JdbcUtil.getConnection;

import java.sql.Connection;

import Project.beans.Member;
import Project.beans.MemberImg;
public class ProjectInfoChangeService {
	
	public Member selectUserInfo(String id) {
		
		Connection conn=null;
		conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		
		Member member=pjd.userInfo(id);
		
		close(conn);
		return member;
	}
	
	public MemberImg userInfoImg(String id) {
		Connection conn=null;
		conn=getConnection();
		ProjectData pjd=ProjectData.getInstance();
		pjd.setConnection(conn);
		MemberImg mb=pjd.userInfoImg(id);
		
		close(conn);
		return mb;
	}
}
