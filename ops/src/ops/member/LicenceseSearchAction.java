package ops.member;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;

//라이센스 조회
public class LicenceseSearchAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) {
		ActionForward forward=null;
		String liceName=request.getParameter("liceName");
		String liceNum=request.getParameter("liceNum");
		if(liceName==null||liceNum==null&&liceName==""||liceNum=="") {
			request.setAttribute("lice", "");	
		}else {
			LicenceseSearchService lss=new LicenceseSearchService();
			HashMap<String, String> lice=lss.emBusinessLicence(liceName, liceNum);
			request.setAttribute("lice", lice);	
		}
		forward=new ActionForward("../join/licenSearch.jsp",false);
		return forward;
	}
}
