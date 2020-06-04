package ops.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
///로그인 확인
public class LoginCk{
	public LoginCk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String userID=null;
		String emID=null;
		
		if(session.getAttribute("userID")!=null) {
			userID=(String) session.getAttribute("userID");
		}else if((String) session.getAttribute("emID")!=null) {
			emID=(String) session.getAttribute("emID");
		}
		request.setAttribute("userID", userID);
		request.setAttribute("emID", emID);
	}
}
