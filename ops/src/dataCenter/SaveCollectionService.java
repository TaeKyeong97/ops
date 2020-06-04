package dataCenter;

import static common.DataCenterDAO.close;
import static common.DataCenterDAO.commit;
import static common.DataCenterDAO.getConnection;
import static common.DataCenterDAO.rollback;

import java.sql.Connection;

import dataCenter.beans.applyCollectionBeans;

/*
 * 달별 수집정보 저장
 */
public class SaveCollectionService {
	public int saveCollection(int selectState,String interest,String appc_date,String boardForm,String click, applyCollectionBeans acb) {
		int state=0;
		Connection conn=getConnection();
		CenterDAO cd=CenterDAO.getInstance();
		cd.setConnection(conn);
		state=cd.saveCollectionInfo(selectState, interest, appc_date, boardForm, click,acb);
		if(state>0) {
			commit(conn);
		}else {
			rollback(conn);
		}		
		close(conn);
		return state;
	}
}
