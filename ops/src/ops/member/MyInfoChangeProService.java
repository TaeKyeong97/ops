package ops.member;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

//회원정보수정 처리페이지
public class MyInfoChangeProService {
	public int myInfoChangeProService(String pw, String userID) {
		int state=0;
		Connection conn=getConnection();
		MemberDAO md=new MemberDAO();
		md.setConnection(conn);
		int x=md.userChange(pw, userID);
		if(x>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
}
