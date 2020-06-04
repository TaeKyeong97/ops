package ops.member;

import java.sql.Connection;
import static common.ConUtilDAO.*;

public class MyInfoChangePageService {
	public int myInfoChangePageService(String userID,String userPW){
		Connection conn=getConnection();
		MemberDAO mb=MemberDAO.getInstance();
		mb.setConnection(conn);
		int state=mb.loginUserPro(userID, userPW);
		
		close(conn);
		return state;
	}
}
