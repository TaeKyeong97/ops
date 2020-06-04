package Project.pro.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;

public class DeleteFileService {
	//파일삭제
	public int deleteFileService(int file_no, String myId) {
		int state=0;
		Connection conn=getConnection();
		OpData od=OpData.getInstance();
		od.setConnection(conn);
		state=od.deleteFile(file_no, myId);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);		
		return state;		
	}
	
}
