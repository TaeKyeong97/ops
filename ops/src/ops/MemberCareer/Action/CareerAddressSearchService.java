package ops.MemberCareer.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.MemberCareer.Beans.Loc;

public class CareerAddressSearchService {
	public ArrayList<Loc> getAddressList(){
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		ArrayList<Loc> list = cd.selectAddressList();
		close(con);
		return list;
	}
}

