package dataCenter;

import java.sql.Connection;
import java.util.ArrayList;
import static common.DataCenterDAO.*;
import dataCenter.beans.applySettingBeans;
//현재 설정값 가져오기
public class CollectionInfoListService {
	public ArrayList<applySettingBeans> CollectionInfoList() {
		Connection conn=getConnection();
		CenterDAO cd=CenterDAO.getInstance();
		cd.setConnection(conn);
		ArrayList<applySettingBeans> applb=cd.collectionInfoList();

		
		close(conn);
		return applb;
	}
}
