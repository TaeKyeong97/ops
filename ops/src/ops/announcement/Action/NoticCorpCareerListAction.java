package ops.announcement.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import ops.Notice.Beans.Notice;
import ops.portfolio.Errorcommand;
//공고 지원 현황 조회(기업 입장)
public class NoticCorpCareerListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String myId=(String)session.getAttribute("userID");
		String emId=(String)session.getAttribute("emID");
		int n_no=0;
		if(request.getParameter("n_no")!=null) {
			n_no=Integer.parseInt(request.getParameter("n_no"));
		}
		if(emId!=null) {
			NoticCareerListService ncls=new NoticCareerListService();
			ArrayList<Notice> ntb=ncls.noticCorpCareerList(emId,n_no);
			ArrayList<Integer> portSize=new ArrayList<Integer>();
			if(ntb!=null) {
				for(int ntbSize=0; ntbSize<ntb.size();ntbSize++) {
					portSize.add(ncls.noticPortfolioSize(ntb.get(ntbSize).getCa_no()));
				}
			
			
				//지원공고 제목 번호 반환
				request.setAttribute("ntb", ntb);
				request.setAttribute("ntbSize", ntb.size());
				request.setAttribute("portSize", portSize);
			}
			forward = new ActionForward("management/NoticCorpSupportList.jsp",false);
		}else {
			if(emId==null) {
				Errorcommand.Error(response, "일반회원은 이용불가한 상품 입니다.","ops/main");
			}else{
				Errorcommand.Error(response, "비정상적인 접근이 감지 되었습니다.","LOGIN/login?loginCk?=0");
			}
		}
		return forward;
	}
}
