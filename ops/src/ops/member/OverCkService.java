package ops.member;

import java.sql.Connection;
import static common.ConUtilDAO.*;

public class OverCkService {
	//일반 중복체크
	public int overCkService(String id) {
		int state=0;
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);		
		state=md.overCk(id);
		
		close(conn);
		return state;
	}
	
	//기업 중복체크
	public int overCk2Service(String id) {
		int state=0;
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);		
		state=md.overCk2(id);
		
		close(conn);
		return state;
	}
}
