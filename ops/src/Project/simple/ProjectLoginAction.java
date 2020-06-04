package Project.simple;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Action;
import comm.ActionForward;

public class ProjectLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response){
		ActionForward forward=null;
		String logCk="0";
		String loginCk1="border-color: rgb(180, 184, 192); background: rgb(243, 243, 243);";
		String loginCk2="border-color: rgb(96, 129, 247); background: rgb(248, 248, 248);";
		String loginCk3="border-color: rgb(247, 96, 96); background: rgb(248, 248, 248);";
		if(request.getParameter("loginCk")==null){
			logCk="0";
		}else{
			if(request.getParameter("loginCk")=="1"||request.getParameter("loginCk").equals("1")){
				logCk="1";
			}else{
				logCk="0";
			}
		}
		
		//넘겨 받은 URL
		String URL=null;
		if(request.getParameter("URL")!=null){
			URL= request.getParameter("URL");
		}else{
			URL="https://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI();
		}
		HttpSession session=request.getSession();
		String EM_id=(String)session.getAttribute("EM_id");
		request.setAttribute("EM_id",EM_id);
		request.setAttribute("URL", URL);
		
		request.setAttribute("loginCk1", loginCk1);
		request.setAttribute("loginCk2", loginCk2);
		request.setAttribute("loginCk3", loginCk3);
		request.setAttribute("logCk", logCk);
		
		forward=new ActionForward("login.jsp",false);
		return forward;
	}
}
