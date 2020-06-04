package ops.member;

import static common.ConUtilDAO.*;

import java.sql.Connection;

import ops.member.beans.EmemberBean;
import ops.member.beans.MemberBean;
//회원가입 처리 페이지
public class JoinProService {
	//일반회원
	public int joinPro(MemberBean mb) throws Exception{
		int state=0;
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);
		
		state=md.joinPro(mb);
		
		if(state==1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		close(conn);
		return state;
	}
	//기업회원
	public int joinEmPro(EmemberBean emb,String uni_uniqueName, String uni_uniqueCodeNo){
		int state=0;
		Connection conn=getConnection();
		MemberDAO md=MemberDAO.getInstance();
		md.setConnection(conn);
		state=md.joinEmPro(emb, uni_uniqueCodeNo, uni_uniqueCodeNo);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return state;
	}
}
