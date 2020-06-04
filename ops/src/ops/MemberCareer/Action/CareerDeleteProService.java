package ops.MemberCareer.Action;

import java.sql.Connection;
import static common.ConUtilDAO.*;

public class CareerDeleteProService {
public boolean isArticleWriter(int ca_no) throws Exception {
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		isArticleWriter = cd.isArticleCareerWriter(ca_no);
		close(con);
		return isArticleWriter;
		
	}

	public boolean removeArticle(int ca_no) throws Exception{
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		int deleteCount = cd.deleteArticle(ca_no);
		
		if(deleteCount > 0){
			commit(con);
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
}
