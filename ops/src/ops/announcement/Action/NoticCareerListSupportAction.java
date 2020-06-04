package ops.announcement.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Action.CareerListService;
import ops.MemberCareer.Beans.Career;
import ops.portfolio.Errorcommand;

public class NoticCareerListSupportAction implements Action{
	//공고 지원을 위해 연결할 이력서 조회
	//연재 페이지에서 지원하기
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String) session.getAttribute("userID");
		String emId=(String)session.getAttribute("emID");
		if(myId!=null) {
			CareerListService cls=new CareerListService();
			ArrayList<Career> myCareerList=cls.getCareerList(myId);
			
			request.setAttribute("myCareerList", myCareerList);
			forward = new ActionForward("management/myCareerList.jsp",false);
		}else {
			try {
				if(emId!=null) {
					Errorcommand.Error(response, "기업회원은 이용불가한 상품 입니다.","ops/main");
				}else {
					Errorcommand.Error(response, "기업회원 로그인 후 이용가능한 서비스 입니다.","LOGIN/login?loginCk?=0");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return forward;
	}
	
}
