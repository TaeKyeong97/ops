package ops.MemberCareer.Action;

import static common.ConUtilDAO.close;
import static common.ConUtilDAO.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Career;
import ops.MemberCareer.Beans.Careerfile;
import ops.member.MyPageService;
import ops.member.beans.MemberBean;
import ops.portfolio.PortfolioCareerLinkList;
import ops.portfolio.beans.PortfolioBeans;


public class CareerDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int ca_no = Integer.parseInt(request.getParameter("ca_no"));
		
		//////////////////////////////
		Career view = null;
		Connection con = getConnection();
		CareerData cd = CareerData.getInstance();
		cd.setConnection(con);
		view = cd.selectDetail(ca_no);
		
		//////////////////////////////
		/*추가*/
		MyPageService mps=new MyPageService();
		MemberBean mb=mps.myPageService(view.getId());
		PortfolioCareerLinkList pcl=new PortfolioCareerLinkList();
		ArrayList<PortfolioBeans> pbl=pcl.portfolioCareerList(ca_no);
		ArrayList<Careerfile> sfile=cd.selectFile(ca_no);
		/**/
		close(con);
		request.setAttribute("view", view);
		request.setAttribute("mName", mb);
		request.setAttribute("pbl", pbl);
		request.setAttribute("sfile", sfile);
		ActionForward forward = new ActionForward("career/careerView.jsp",false);
		return forward;
}
}

