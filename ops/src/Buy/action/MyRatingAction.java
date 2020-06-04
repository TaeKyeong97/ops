package Buy.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.RatingBean;
import comm.Action;
import comm.ActionForward;

public class MyRatingAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 나의 등급 조회
		ActionForward forward=null;
		
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("EM_id");
		String EM_name=(String)session.getAttribute("EM_name");
		
		MyRatingService mrs=new MyRatingService();
		ArrayList<RatingBean> rba=mrs.myRatingService(myId);
		int price=0;
		if(rba!=null) {
			for(int i=0;i<rba.size();i++) {
				price+=Integer.parseInt(rba.get(i).getBuy_price());
			}
		}
		
		
		if(price>3000) {
			request.setAttribute("rating", "VIP");
		}else if(price>2000){
			request.setAttribute("rating", "프리미엄");
		}else if(price>=0){
			request.setAttribute("rating", "일반");
		}
		request.setAttribute("EM_name", EM_name);
		
		
		
		forward=new ActionForward("rating.jsp",false);
		
		return forward;
	}
}
