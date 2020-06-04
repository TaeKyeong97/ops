package ops.member;

import java.sql.Connection;

import ops.member.beans.MemberBean;

import static common.ConUtilDAO.*;

public class MyInfoChangeProPageService {
	public MemberBean myInfoChangeProPageService(String id) {
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);
		MemberBean mb=md.MyInfo(id);
		
		close(conn);
		
		return mb;
	}
}
