package ops.MemberCareer.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import ops.MemberCareer.Beans.Loc;

public class CareerAddressSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		CareerAddressSearchService cass = new CareerAddressSearchService();
		ArrayList<Loc> list = cass.getAddressList();
		request.setAttribute("list", list);
		forward = new ActionForward("./addressSearch.jsp", false);
		return forward;
	}
}

