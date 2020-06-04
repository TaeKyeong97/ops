package ops.MemberCareer.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.commit;
import static common.ConUtilDAO.getConnection;
import static common.ConUtilDAO.rollback;

import java.sql.Connection;

import ops.MemberCareer.Beans.Career;

public class CareerModifyProService {
	public boolean isArticleWriter(int ca_no) throws Exception {
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		isArticleWriter = cd.isArticleCareerWriter(ca_no);
		close(con);
		//System.out.println("isArticleWriter = " + isArticleWriter);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(Career article) throws Exception {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		int updateCount = cd.updateArticle(article);
		//System.out.println("updateCount = " + updateCount);
		if(updateCount > 0){
			commit(con);
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}

}
