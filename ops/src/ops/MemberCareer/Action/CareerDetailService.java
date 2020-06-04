package ops.MemberCareer.Action;

import java.sql.Connection;
import static common.ConUtilDAO.*;
import ops.MemberCareer.Beans.Career;

public class CareerDetailService {
	public Career getArticle(int ca_no) throws Exception{
		
		Career article = null;
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		
		article = cd.selectDetail(ca_no);
		close(con);
		return article;
		
	}
}

