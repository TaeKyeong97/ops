package dataCenter;

import java.sql.Connection;
import static common.DataCenterDAO.*;

/*
 * 검색 또는 상태 정보 가져오기
 */
public class SelectStateCollection {
	public int selectStateCollection(String startDate, String interest,String boardForm) {
		Connection conn=getConnection();
		CenterDAO cd=CenterDAO.getInstance();
		cd.setConnection(conn);
		int state=cd.selectAppCollection(startDate, interest, boardForm);
		
		close(conn);
		return state;
	}
}
