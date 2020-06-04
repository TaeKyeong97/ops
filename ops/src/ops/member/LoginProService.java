package ops.member;

import java.sql.Connection;
import static common.ConUtilDAO.*;
//로그인 처리 페이지
public class LoginProService{
	//일반 회원
	public int loginUserProService(String userID,String userPW) {
		int state=0;
		Connection conn=getConnection();
		MemberDAO md=new MemberDAO();
		md.setConnection(conn);
		state=md.loginUserPro(userID, userPW);
		
		
		close(conn);		
		return state;
	}
	//기업회원
	public int loginCorpProService(String userID,String userPW) {
		int state=0;
		Connection conn=getConnection();
		MemberDAO md=new MemberDAO();
		md.setConnection(conn);
		state=md.loginCorpPro(userID, userPW);
		
		close(conn);		
		return state;
	}
}
