package ops.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Career;
import ops.portfolio.beans.PortfolioBeans;
/*
 * 통합검색
 */
public class SearchAction implements Action{
	public ActionForward execute(HttpServletRequest request ,HttpServletResponse response)throws Exception {
		ActionForward forward=new ActionForward("../SEARCH/search.jsp",false);
		String query=request.getParameter("query");
		
		String acbg=request.getParameter("reqsSettAB");			//학력 (중학교,고등학교)
		String acbgState=request.getParameter("abgState");		//학력 상태
		String money=request.getParameter("money");				//연봉
		String sex=request.getParameter("sex");					//성별	
		String local=request.getParameter("locals");						//지역
		String detailLocal=request.getParameter("locDedetailSett");			//상세지역
		String industry=request.getParameter("industry");				//업종
		String detailIndustry=request.getParameter("detailIndustry");	//상세 업종
		 
		if(query!=null) {
			ArrayList<Career> scl=null;
			ArrayList<NoticBeans> snl=null;
			//필터 저장
			FilterABeans fb=new FilterABeans(local,detailLocal,industry,detailIndustry,acbg,acbgState,money,sex);
			/*
			 * 검색어추출
			 */
			SearchService ss=new SearchService();
			ArrayList<ArrayList<String>> q=ss.search(query);
			/*
			 * 검색 01 (필터없음)
			 */
			//포트폴리오 검색 엔진(번호 추출)
			ArrayList<PortfolioBeans> spfl=ss.searchPortfolioList(q);
			//이력서 검색엔진 (필터 없음)
			if(fb.getAcbg()==null||fb.getAcbgState()==null||fb.getDetailIndustry()==null||fb.getDetailLocal()==null||fb.getIndustry()==null||fb.getLocal()==null||fb.getMoney()==null||fb.getSex()==null) {
				scl=ss.searchCareerList(q);
				snl=ss.searchNoticList(q, fb);
			}
			
			/*
			 * 검색 02 (필터 사용 또는 미사용)
			 */
			//포트폴리오 검색 결과 및 필터검색결과 (필터 사용 또는 미 사용) <현재 미사용>
			ArrayList<PortfolioBeans> searchpfls=ss.searchPortfolioLists(spfl,fb);
			//출력 (필터 검색 사용 또는 미사용)	
			request.setAttribute("searchpfls", searchpfls);
			
			/*
			 * 검색 03 (필터사용)
			 */
			if(fb.getAcbg()!=null&&!fb.getAcbg().equals("")||fb.getAcbgState()!=null&&!fb.getAcbgState().equals("")||fb.getDetailIndustry()!=null&&!fb.getDetailIndustry().equals("")||fb.getDetailLocal()!=null&&!fb.getDetailLocal().equals("")||fb.getIndustry()!=null&&!fb.getIndustry().equals("")||fb.getLocal()!=null&&!fb.getLocal().equals("")||fb.getMoney()!=null&&!fb.getMoney().equals("")||fb.getSex()!=null&&!fb.getSex().equals("")) {
				//이력서 검색 (필터사용)
				if(scl!=null&&fb.getLocal()!=null&&!fb.getLocal().equals("")||fb.getAcbg()!=null&&!fb.getAcbg().equals("")||fb.getMoney()!=null&&!fb.getMoney().equals("")) {
					ArrayList<Career> searchcls=ss.searchCareerLists(scl,fb);
					request.setAttribute("searchcls", searchcls);		//이력서
				}else {
					request.setAttribute("searchcls", scl);
				}				
				ArrayList<NoticBeans> searnotics=ss.searchNoticeLists(q,fb);
				
				request.setAttribute("searnotics", searnotics);

			}else{
				//출력 (필터제외)
				request.setAttribute("searchcls", scl);				//이력서
				request.setAttribute("searnotics", snl);//공고검색
			}
			
			
		}
		return forward;
	}
}
