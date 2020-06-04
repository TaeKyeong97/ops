package net.chat_test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project.beans.chatBrocket;
import comm.Action;
import comm.ActionForward;

public class ChatAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward("chat/broadcast.jsp",false);
		String testData=request.getParameter("test");
		HttpSession session=request.getSession();
		String myid=(String)session.getAttribute("EM_id");
		//나의 아이디 반환
		request.setAttribute("myid", myid);
		
		
		return forward;
	}

}
