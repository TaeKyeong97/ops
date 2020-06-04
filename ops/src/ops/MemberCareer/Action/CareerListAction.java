package ops.MemberCareer.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Career;
import ops.member.MyPageService;
import ops.member.beans.MemberBean;
import ops.portfolio.Errorcommand;
//My 이력서 리스트 조회
public class CareerListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("userID");
		String emId=(String)session.getAttribute("emID");
		if(myId!=null) {
		CareerListService cls = new CareerListService();
   		ArrayList<Career> careerList = cls.getCareerList(myId);
   		MyPageService mps=new MyPageService();
   		MemberBean mb=mps.myPageService(myId);
   		
   		request.setAttribute("careerList", careerList);
   		request.setAttribute("myProfile", mb.getProfile());
   		request.setAttribute("myId", myId);
   		forward = new ActionForward("career/careerList.jsp",false);
		}else {
			if(emId!=null) {
				Errorcommand.Error(response, "기업회원은 이용불가한 상품 입니다.","ops/main");
			}else {
				Errorcommand.Error(response, "로그인후 이용가능한 서비스 입니다.","LOGIN/login?loginCk?=0");
			}	
		}
   		return forward;
	}
}
