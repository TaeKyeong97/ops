package ops.MemberCareer.Action;

import java.sql.Connection;
import static common.ConUtilDAO.*;
import ops.MemberCareer.Beans.Careerfile;

//파일 업로드
public class UploadService {
	public int upload(Careerfile cf) {
		int state=0;
		Connection conn=getConnection();
		CareerData cd=CareerData.getInstance();
		cd.setConnection(conn);
		state=cd.uploadFile(cf);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);		
		return state;
	}
	//방금 생성한 이력서 번호 조회
	public int careerNextNumber(String userId) {
		int state=0;
		Connection conn=getConnection();
		CareerData cd=CareerData.getInstance();
		cd.setConnection(conn);
		state=cd.careerNextNumber(userId);		
		
		close(conn);
		return state;
	}
}
