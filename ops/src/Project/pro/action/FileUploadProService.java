package Project.pro.action;

import java.sql.Connection;
import static comm.JdbcUtil.*;

public class FileUploadProService {
	public int fileUploadProService(String folder,String fileName,int pj_no,int pjgp_no,String exten,String myId) {
		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		int state=opd.uploadPro(folder, fileName, pj_no,pjgp_no,exten,myId);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return state;
	}
}
