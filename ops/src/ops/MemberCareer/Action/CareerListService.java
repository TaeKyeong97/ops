package ops.MemberCareer.Action;

import java.sql.Connection;
import java.util.ArrayList;
import static common.ConUtilDAO.*;
import ops.MemberCareer.Beans.Career;

public class CareerListService {
	public ArrayList<Career> getCareerList(String myId) {
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		ArrayList<Career> careerList = cd.selectCareerList(myId);
		close(con);
		return careerList;
	}

}


