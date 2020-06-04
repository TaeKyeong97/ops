package ops.member;

import java.sql.Connection;
import static common.ConUtilDAO.*;

public class UserNameFiendService {
	public String userNameFiend(String userID) {
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);
		String userName=md.userName(userID);
		
		close(conn);
		return userName;
	}
}
