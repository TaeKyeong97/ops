package ops.MemberCareer.Action;
import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import ops.MemberCareer.Beans.Work;

public class CareerWorkSearchService {
	public ArrayList<Work> getWorkList(){
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		ArrayList<Work> workList = cd.selectWorkList();
		close(con);
		return workList;
	}
}
