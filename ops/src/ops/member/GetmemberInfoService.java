package ops.member;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;

import ops.member.beans.MemberBean;
//공개 가능한 나의 회원 정보 가져오기
public class GetmemberInfoService {
	public MemberBean getUserInfo(String myID) {
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);
		MemberBean mb=md.getUserInfo(myID);
		close(conn);
		return mb;
	}
}
