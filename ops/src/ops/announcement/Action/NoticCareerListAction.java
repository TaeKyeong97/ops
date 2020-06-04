package ops.announcement.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;
import ops.portfolio.Errorcommand;
//공고 지원 현황 조회(일반사용자 입장)
public class NoticCareerListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("userID");
		String emId=(String)session.getAttribute("emID");
		if(myId!=null) {
			NoticCareerListService ncls=new NoticCareerListService();
			ArrayList<Notice> ntb=ncls.noticCareerList(myId);
			ArrayList<Integer> portSize=new ArrayList<Integer>();
			for(int ntbSize=0; ntbSize<ntb.size();ntbSize++) {
				portSize.add(ncls.noticPortfolioSize(ntb.get(ntbSize).getCa_no()));
			}
			
			//지원공고 제목 번호 반환
			request.setAttribute("ntb", ntb);
			request.setAttribute("ntbSize", ntb.size());
			request.setAttribute("portSize", portSize);
			forward = new ActionForward("management/NoticSupportList.jsp",false);
		}else {
			if(emId!=null) {
				Errorcommand.Error(response, "기업회원은 이용 불가한 상품 입니다.","ops/main");
			}else {
				Errorcommand.Error(response, "로그인후 이용가능한 서비스 입니다.","LOGIN/login?loginCk?=0");
			}			
		}
		return forward;
	}
}
