package ops.member;

import java.sql.Connection;
import static common.ConUtilDAO.*;

public class SearchPasswordService {
	public String searchPasswordService(String myId, String phone) {
		//비밀번호 찾기
		String password=null;
		Connection conn=getConnection();
		MemberDAO pjd=MemberDAO.getInstance();
		pjd.setConnection(conn);
		password=pjd.searchPassword(myId, phone);
		if(password!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return password;
	}
}
