package dataCenter;

import static common.DataCenterDAO.close;
import static common.DataCenterDAO.commit;
import static common.DataCenterDAO.getConnection;
import static common.DataCenterDAO.rollback;

import java.sql.Connection;

import dataCenter.beans.DataCenterBeans;

public class CenterSettingProService {
	//관심 분야 데이터 저장
	public int centerSettingPro(DataCenterBeans dcb) {
		int state=0;
		Connection conn=getConnection();
		CenterDAO cd=CenterDAO.getInstance();
		cd.setConnection(conn);
		state=cd.acceptSave(dcb);
		
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}		
		close(conn);		
		return state;
	}
}
