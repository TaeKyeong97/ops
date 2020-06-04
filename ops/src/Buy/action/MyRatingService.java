package Buy.action;

import java.sql.Connection;
import java.util.ArrayList;

import static comm.JdbcUtil.*;
import Project.beans.RatingBean;

public class MyRatingService {
	public ArrayList<RatingBean> myRatingService(String myId) {
		Connection conn=getConnection();
		BuyData bd=BuyData.getInstance();
		bd.setConnection(conn);

		ArrayList<RatingBean> rab=bd.myRating(myId);
		
		
		close(conn);
		return rab;
	}
}
