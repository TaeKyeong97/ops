package dataCenter;

import static common.DataCenterDAO.close;
import static common.DataCenterDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dataCenter.beans.collectionBeans;

//수집 정보 가져오기
public class CollectionListService {
	public ArrayList<collectionBeans> collectionList() {
		Connection conn=getConnection();
		CenterDAO ctd=CenterDAO.getInstance();
		ctd.setConnection(conn);
		ArrayList<collectionBeans> ccl=ctd.collectionList();
		close(conn);
		return ccl;
	}
	//달별 수집정보 가져오기
	public ArrayList<collectionBeans> monthList(){
		Connection conn=getConnection();
		CenterDAO ctd=CenterDAO.getInstance();
		ctd.setConnection(conn);
		ArrayList<collectionBeans> mtl=ctd.monthList();
		close(conn);
		return mtl;
	}
}
