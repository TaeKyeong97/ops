package Project.pro.action;

import java.sql.Connection;
import java.util.ArrayList;

import Project.beans.UploadFileBean;

import static comm.JdbcUtil.*;

public class SharingListService {
	public ArrayList<UploadFileBean> sharingListService(int pj_no,int pjg_no) {

		Connection conn=getConnection();
		OpData opd=OpData.getInstance();
		opd.setConnection(conn);
		ArrayList<UploadFileBean> list=opd.uploadList(pj_no, pjg_no);
		
		
		close(conn);
		return list;
		
	}
}
