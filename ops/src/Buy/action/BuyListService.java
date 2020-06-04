package Buy.action;

import java.sql.Connection;
import java.util.ArrayList;
import static comm.JdbcUtil.*;
import Project.beans.BuyBean;

public class BuyListService {
	public ArrayList<BuyBean> buyListService(String myId) {
		Connection conn=getConnection();
		BuyData bd=BuyData.getInstance();
		bd.setConnection(conn);
		
		ArrayList<BuyBean> list=bd.buyList(myId);
		
		close(conn);
		return list;
	}
}
