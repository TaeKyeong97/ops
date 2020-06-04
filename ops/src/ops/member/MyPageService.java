package ops.member;

import java.sql.Connection;
import java.util.ArrayList;

import ops.member.beans.MemberBean;

import static common.ConUtilDAO.*;

public class MyPageService {
	//회원 개인페이지 정보가져오기
	public MemberBean myPageService(String memberId) {
		
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);
		MemberBean mb=md.memberPage(memberId);
		
		
		close(conn);		
		return mb;
	}
}
