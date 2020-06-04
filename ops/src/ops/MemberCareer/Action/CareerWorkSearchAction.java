package ops.MemberCareer.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Work;

public class CareerWorkSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		CareerWorkSearchService cwss = new CareerWorkSearchService();
		ArrayList<Work> workList = cwss.getWorkList();
		request.setAttribute("workList", workList);
		forward = new ActionForward("./workSearch.jsp", false);
		
		return forward;
	}
}
