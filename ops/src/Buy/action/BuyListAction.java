package Buy.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.BuyBean;
import comm.Action;
import comm.ActionForward;

public class BuyListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward =null;
		HttpSession session=request.getSession();
		String myId=(String) session.getAttribute("EM_id");
		
		BuyListService bls=new BuyListService();
		ArrayList<BuyBean> buyList=bls.buyListService(myId);
		request.setAttribute("buyList", buyList);
		
		forward=new ActionForward("buy.jsp",false);
		
		return forward;	
		
	}

}
